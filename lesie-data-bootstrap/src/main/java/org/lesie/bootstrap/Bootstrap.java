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

package org.lesie.bootstrap;

import org.lesie.data.service.OrganisationService;
import org.lesie.model.Application;
import org.lesie.model.Organisation;

import java.util.ArrayList;
import java.util.List;

public class Bootstrap {

    private Organisation org;
    private OrganisationService orgService;

    /*
    * This method builds sample organisation data,that is to say
    * This will build a sample organisation, with a corresponding application
    * that has been registered in that particular organisation*/
    public void buildOrgData(){
        //sample organisation
        Organisation tmpOrg = new Organisation();
        tmpOrg.setKey("QqAaZz");
        tmpOrg.setName("Test Org");

        //sample application
        Application tmpApp = new Application();
        tmpApp.setAppKey("zZaAqQ");
        tmpApp.setDescription("Data moving application");

        //attach organisation to application
        ArrayList<Application> newAppList =new ArrayList();
        newAppList.add(tmpApp);
        tmpOrg.setApplications(newAppList);
        tmpApp.setOrganisation(tmpOrg);
        orgService.add(tmpOrg);
        //return tmpOrg;
    }

    public OrganisationService getOrgService() {
        return orgService;
    }

    public void setOrgService(OrganisationService orgService) {
        this.orgService = orgService;
    }
}
