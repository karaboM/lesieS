/**
 *      Copyright 2013 CPUT
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

import org.lesie.queue.LesieQueue;
import org.lesie.queue.QueueRequestObject;
import org.lesie.queue.QueueResponseObject;
import sun.org.mozilla.javascript.internal.ast.Block;

import java.util.UUID;
import java.util.concurrent.*;

public class LesieQueueImpl  implements LesieQueue{

    private BlockingQueue<QueueRequestObject> inQueue;
    private BlockingQueue<QueueResponseObject> outQueue;
    private ConcurrentMap<String,QUEUE_STATE> requestResponseMap;
    private UUID uuid;

    private enum QUEUE_STATE{
        IN_QUEUE,
        OUT_QUEUE
    }

    public LesieQueueImpl(){
        inQueue = new LinkedBlockingDeque<QueueRequestObject>() ;
        outQueue = new LinkedBlockingDeque<QueueResponseObject>();
        requestResponseMap = new ConcurrentHashMap<String, QUEUE_STATE>();
    }

    @Override
    public String generateToken() {
        String token = uuid.toString();

        if(requestResponseMap.containsKey(token) == false){
            requestResponseMap.put(token,QUEUE_STATE.IN_QUEUE);
        }else{
            QUEUE_STATE currentState = requestResponseMap.get(token);
            if(currentState.equals(QUEUE_STATE.OUT_QUEUE)){
                //throw exception here to indicate that the token has already been added to the queue

            }
        }

        return null;
    }

    @Override
    public Object findResponseByToken(String token) {
        return null;
    }

    @Override
    public void processRequest(QueueRequestObject requestObj) {

    }
}
