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

package org.lesie.api.impl.connection;

import org.lesie.api.connection.ConnectionManagerAPI;
import org.lesie.connection.ConnectionManager;
import org.lesie.dto.response.LesieResponseDTO;

import javax.ws.rs.QueryParam;

public class ConnectionManagerAPIImpl implements ConnectionManagerAPI {


    private ConnectionManager connectionManager;

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }


    @Override
    public LesieResponseDTO login(String clientName, String identityKey) {
        return connectionManager.login(clientName,identityKey);
    }

    @Override
    public LesieResponseDTO logout(String clientName, String sessionKey) {
        return connectionManager.logout(clientName,sessionKey);
    }
}
