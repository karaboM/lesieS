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
import org.lesie.model.Organisation;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.List;

public class Activator implements BundleActivator {

    private Bootstrap bootstrap;
    private OrganisationService organisationService;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void onBindService(final OrganisationService organisationService) {
        if (organisationService != null) {
            System.out.println("building sample data for organisationService");
            //Organisation org = bootstrap.buildOrgData();
            //organisationService.add(org);
        } else{
            System.out.println("organisationService is null");
        }
    }

    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }
}
