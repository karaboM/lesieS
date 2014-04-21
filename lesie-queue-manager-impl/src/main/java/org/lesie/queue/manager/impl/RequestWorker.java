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

package org.lesie.queue.manager.impl;

import org.lesie.dto.request.LesieRequestDTO;
import org.lesie.dto.response.LesieResponseDTO;
import org.lesie.queue.LesieQueue;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.Callable;

public class RequestWorker implements Callable<LesieResponseDTO> {

    private LesieQueue workQueue;

    private LesieRequestDTO queueRequestObject;
    private LesieResponseDTO queueResponseObject;

    public RequestWorker(LesieQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public LesieResponseDTO call() throws Exception {
        return dummyResponse();
    }

    private LesieResponseDTO dummyResponse() {
        LesieResponseDTO responseObject = new LesieResponseDTO();
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        responseObject.setRequestToken(workQueue.getCurrentToken());
        responseObject.setTimestamp(timestamp.toString());
        responseObject.setResult(new String("hahahaha"));

        return responseObject;
    }
}
