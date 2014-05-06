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

package org.lesie.handler.impl;

import org.lesie.dto.request.LesieRequestDTO;
import org.lesie.dto.response.LesieResponseDTO;
import org.lesie.handler.LesieHandler;

import java.util.Map;

/*Name:LesieHandlerImpl
 *Description: The purpose of this class is to serve as the default handler class, by that it
 * is meant. This class will be the entry point to the set of defined Handler classes.
 * This class will delegate to the appropriate handler based on the commandName.
 *
 *
 */
public class LesieHandlerImpl implements LesieHandler {

    private Map<String,LesieHandler> handlers;
    @Override
    public LesieResponseDTO processRequest(LesieRequestDTO requestDTO) {
        LesieHandler handler = handlers.get(requestDTO.getCommandName());
        //need to throw LesieCommandHandlerNotFoundException
        LesieResponseDTO response= new LesieResponseDTO();
        response.fillSimilar(requestDTO);


        response= handler.processRequest(requestDTO);
        response.generateTimestamp();
        return response;

    }


    public void setHandlers(Map<String, LesieHandler> handlers) {
        this.handlers = handlers;
    }
}
