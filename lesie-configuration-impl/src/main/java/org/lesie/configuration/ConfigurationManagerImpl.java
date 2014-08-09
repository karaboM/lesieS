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

package org.lesie.configuration;

import org.lesie.dto.response.LesieResponseDTO;
import org.lesie.kernel.SwitchBoard;
import org.lesie.kernel.api.Command;

import java.util.HashMap;

public class ConfigurationManagerImpl implements ConfigurationManager {
    private SwitchBoard switchBoard;

    @Override
    public LesieResponseDTO getConfigByApplication(String appKey) {
        HashMap<String,String> parameters = new HashMap<String, String>();
        parameters.put("appKey",appKey);

        LesieResponseDTO result = switchBoard.command(Command.GET_APP_CONFIG,parameters);
        return result;
    }




    public SwitchBoard getSwitchBoard() {

        return switchBoard;
    }

    public void setSwitchBoard(SwitchBoard switchBoard) {
        this.switchBoard = switchBoard;
    }
}
