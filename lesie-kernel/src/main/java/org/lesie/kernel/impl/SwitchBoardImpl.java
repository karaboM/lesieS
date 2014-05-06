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

package org.lesie.kernel.impl;

import org.lesie.dto.request.LesieRequestDTO;
import org.lesie.dto.response.LesieResponseDTO;
import org.lesie.kernel.SwitchBoard;
import org.lesie.queue.manager.QueueManager;

import java.util.Map;

public class SwitchBoardImpl implements SwitchBoard {

    private QueueManager queueManager;


    public SwitchBoardImpl(){};

    @Override
    public LesieResponseDTO command(String commandName,Map<String,String> parameters){
        LesieRequestDTO requestObj = new LesieRequestDTO(commandName,parameters);
        String requestToken = queueManager.queueRequest(requestObj);
        LesieResponseDTO responseObject = queueManager.queueResponse(requestToken);
        return responseObject;
    };


    public QueueManager getQueueManager() {
        return queueManager;
    }

    public void setQueueManager(QueueManager queueManager) {
        this.queueManager = queueManager;
    }
}
