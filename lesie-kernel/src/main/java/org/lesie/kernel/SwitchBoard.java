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

package org.lesie.kernel;

import org.lesie.queue.QueueManager;
import org.lesie.queue.QueueRequestObject;
import org.lesie.queue.QueueResponseObject;

import java.util.Map;

public class SwitchBoard {

    private QueueManager queueManager;


    public SwitchBoard(){};

    public Object command(String commandName,Map<String,Object> parameters){
        QueueRequestObject requestObj = new QueueRequestObject(commandName,parameters);
        String requestToken = queueManager.queueRequest(requestObj);
        QueueResponseObject responseObject = queueManager.queueResponse(requestToken);
        return responseObject.getResult();
    };


    public QueueManager getQueueManager() {
        return queueManager;
    }

    public void setQueueManager(QueueManager queueManager) {
        this.queueManager = queueManager;
    }
}
