/**
 *      Copyright 2013 CPUT
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

package org.lesie.connection.api.impl;

import org.lesie.connection.api.ConnectionManager;

public class ConnectionManagerImpl implements ConnectionManager{

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    private ConnectionManager connectionManager;

    @Override
    public String connect(String clientName, String identityKey) {
        return connectionManager.connect(clientName,identityKey);
    }

    @Override
    public boolean disconnect(String clientName, String sessionKey) {
        return connectionManager.disconnect(clientName,sessionKey);
    }
}
