package org.lesie.dto.request;
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

import org.lesie.dto.LesieDTO;

import java.util.Map;

public class LesieRequestDTO extends LesieDTO{

    private Map<String,String> parameters;


    public LesieRequestDTO(String commandName, Map<String, String> parameters) {
        this.commandName = commandName;
        this.parameters = parameters;

    }

    public String getCommandName() {
        return commandName;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }
}
