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
package org.lesie.connection.impl;


import org.lesie.connection.ConnectionManager;
import org.lesie.connection.Session;
import org.lesie.dto.response.LesieResponseDTO;
import org.lesie.kernel.SwitchBoard;
import org.lesie.kernel.api.Command;

import java.util.HashMap;

public class ConnectionManagerImpl implements ConnectionManager {

    private SwitchBoard switchBoard;

    private HashMap<String,Session> sessionMap;
    public void init(){
    }

    @Override
    public LesieResponseDTO login(String clientName, String identityKey) {
        HashMap<String,String> parameters = new HashMap<String, String>();
        parameters.put("clientName",clientName);
        parameters.put("identityKey",identityKey);

        LesieResponseDTO result = switchBoard.command(Command.LOGIN,parameters);
        return result;
    }

    @Override
    public LesieResponseDTO logout(String clientName, String sessionKey) {
        HashMap<String,String> parameters = new HashMap<String, String>();
        parameters.put("clientName",clientName);
        parameters.put("sessionKey",sessionKey);

        LesieResponseDTO result = switchBoard.command(Command.LOGOUT,parameters);
        return result;
    }


    public SwitchBoard getSwitchBoard() {
        return switchBoard;
    }

    public void setSwitchBoard(SwitchBoard switchBoard) {
        this.switchBoard = switchBoard;
    }
}