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

package org.lesie.handler.session.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SessionStorage {
   
    /*for now at this point, will be using hardcoded values
    */
    private List<String> registeredAppList;
    private Map<String,String> activeAppMap;
    
    public SessionStorage(){
        buildSampleData();
        init();
    }

    private void init() {
        activeAppMap = new ConcurrentHashMap<String, String>();
    }

    private void buildSampleData() {
        registeredAppList = new ArrayList<String>();
        registeredAppList.add("1234");
        registeredAppList.add("5678");
        registeredAppList.add("abcd");
        registeredAppList.add("efgh");


    }

    public boolean isRegisteredApp(String appToken){
        return registeredAppList.contains(appToken);
    }

    public String generateSessionKey(String appToken){
        if(isRegisteredApp(appToken)){
            String tmpToken = UUID.randomUUID().toString();

            activeAppMap.put(appToken,tmpToken);
            return tmpToken;
        }
        return null;
    }

    public boolean isActive(String appToken,String sessionKey){
        if(activeAppMap.containsKey(appToken)){
            if(activeAppMap.get(appToken).equals(sessionKey)){
                return true;
            }
        }
        return false;
    }

    public void deactivate(String appToken) {
        activeAppMap.remove(appToken);
    }
}
