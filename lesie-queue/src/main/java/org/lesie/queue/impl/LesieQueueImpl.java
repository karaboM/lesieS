/**
 *      Copyright 2014 CPUT
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package org.lesie.queue.impl;

import org.lesie.dto.request.LesieRequestDTO;
import org.lesie.dto.response.LesieResponseDTO;
import org.lesie.queue.LesieQueue;

import java.util.UUID;
import java.util.concurrent.*;

public class LesieQueueImpl implements LesieQueue {

    private BlockingQueue<LesieRequestDTO> inQueue;
    private ConcurrentMap<String, LesieResponseDTO> outMap;
    private ConcurrentMap<String, QUEUE_STATE> requestResponseMap;
    private UUID uuid;
    private String currentGeneratedToken;

    private enum QUEUE_STATE {
        IN_QUEUE,
        OUT_QUEUE
    }

    public LesieQueueImpl() {
        inQueue = new LinkedBlockingDeque<LesieRequestDTO>();
        outMap = new ConcurrentHashMap<String, LesieResponseDTO>();
        requestResponseMap = new ConcurrentHashMap<String, QUEUE_STATE>();
    }

    @Override
    public LesieResponseDTO findResponseByToken(String token) {

        if (requestResponseMap.containsKey(token)) {
            QUEUE_STATE state = requestResponseMap.get(token);
            if (state == QUEUE_STATE.OUT_QUEUE) {
                if (outMap.containsKey(token)) {
                    return outMap.get(token);
                }
            }
        }

        return null;
    }


    @Override
    public String getCurrentToken() {
        return currentGeneratedToken;
    }

    @Override
    public void addResponseByToken(String token, LesieResponseDTO responseObj) {
        if (requestResponseMap.containsKey(token)) {
            QUEUE_STATE state = requestResponseMap.get(token);
            if (state == QUEUE_STATE.IN_QUEUE) {
                state = QUEUE_STATE.OUT_QUEUE;
                if (requestResponseMap.replace(token, QUEUE_STATE.IN_QUEUE, QUEUE_STATE.OUT_QUEUE)) {
                    outMap.putIfAbsent(token, responseObj);
                }
            }
        }

    }

    @Override
    public String addRequest(LesieRequestDTO requestObj) {
        String retVal = null;
        try {
            retVal = generateToken();
            requestObj.setRequestToken(retVal);
            inQueue.put(requestObj);

        } catch (InterruptedException e) {
            e.printStackTrace();
            retVal = null;
            revertGeneratedToken(retVal);

        }
        return retVal;
    }

    @Override
    public LesieRequestDTO popRequest() {
        return inQueue.poll();
    }

    private void revertGeneratedToken(String token) {
        if(requestResponseMap.containsKey(token) && requestResponseMap.get(token) == QUEUE_STATE.IN_QUEUE){
            requestResponseMap.remove(token);
        }
    }


    private String generateToken() {
        String token = UUID.randomUUID().toString();

        if (requestResponseMap.containsKey(token) == false) {
            requestResponseMap.put(token, QUEUE_STATE.IN_QUEUE);
        } else {
            QUEUE_STATE currentState = requestResponseMap.get(token);
            if (currentState.equals(QUEUE_STATE.IN_QUEUE)) {
                //throw exception here to indicate that the token has already been added to the queue

            }
        }
        currentGeneratedToken = token;
        return token;
    }
}
