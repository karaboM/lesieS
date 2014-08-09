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

package org.lesie.api.impl.configuration;

import org.lesie.api.configuration.ConfigurationManagerAPI;
import org.lesie.configuration.ConfigurationManager;
import org.lesie.dto.response.LesieResponseDTO;

public class ConfigurationManagerAPIImpl implements ConfigurationManagerAPI{

    private ConfigurationManager configManager;

    @Override
    public LesieResponseDTO getConfigByApplication(String appKey) {
        return configManager.getConfigByApplication(appKey);
    }

    public ConfigurationManager getConfigManager() {
        return configManager;
    }

    public void setConfigManager(ConfigurationManager configManager) {
        this.configManager = configManager;
    }
}
