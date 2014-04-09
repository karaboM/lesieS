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

package org.lesie.queue;

import java.util.Map;

public class QueueRequestObject {

    private String commandName;
    private Map<String,Object> parameters;


    public QueueRequestObject(String commandName, Map<String, Object> parameters) {
        this.commandName = commandName;
        this.parameters = parameters;

    }

    public String getCommandName() {
        return commandName;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }
}
