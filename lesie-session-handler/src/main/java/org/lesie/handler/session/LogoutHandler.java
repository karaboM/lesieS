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

package org.lesie.handler.session;

import org.lesie.dto.request.LesieRequestDTO;
import org.lesie.dto.response.LesieResponseDTO;
import org.lesie.handler.LesieHandler;
import org.lesie.handler.session.storage.SessionStorage;

import java.util.Map;

public class LogoutHandler implements LesieHandler {

    private SessionStorage sessionStorage;

    @Override
    public LesieResponseDTO processRequest(LesieRequestDTO requestDTO) {
        LesieResponseDTO response = new LesieResponseDTO();
        response.fillSimilar(requestDTO);

        Map<String,String> parameters = requestDTO.getParameters();
        String appIdentityKey = parameters.get(("identityKey"));
        String clientName = parameters.get("clientName");

        sessionStorage.deactivate(appIdentityKey);

        return response;
    }

    public void setSessionStorage(SessionStorage sessionStorage) {
        this.sessionStorage = sessionStorage;
    }
}
