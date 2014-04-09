/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.lesie.connection.impl;


import org.lesie.connection.ConnectionManager;
import org.lesie.connection.Session;
import org.lesie.kernel.SwitchBoard;
import org.lesie.kernel.api.Command;

import java.util.HashMap;

public class ConnectionManagerImpl implements ConnectionManager {

    private SwitchBoard switchBoard;

    private HashMap<String,Session> sessionMap;
    public void init(){
    }

    @Override
    public String connect(String clientName, String identityKey) {
        HashMap<String,Object> parameters = new HashMap<String, Object>();
        parameters.put("clientName",clientName);
        parameters.put("identityKey",identityKey);

        String result = (String)switchBoard.command(Command.CONNECT,parameters);
        return result;
    }

    @Override
    public boolean disconnect(String clientName, String sessionKey) {
        HashMap<String,Object> parameters = new HashMap<String, Object>();
        parameters.put("clientName",clientName);
        parameters.put("sessionKey",sessionKey);

        Boolean result = (Boolean)switchBoard.command(Command.DISCONNECT,parameters);
        return result;
    }


    public SwitchBoard getSwitchBoard() {
        return switchBoard;
    }

    public void setSwitchBoard(SwitchBoard switchBoard) {
        this.switchBoard = switchBoard;
    }
}