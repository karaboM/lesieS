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

package org.lesie.api.registration;

import org.lesie.dto.response.LesieResponseDTO;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/registration")
@Produces("application/json")
public interface RegistrationManagerAPI {

    public LesieResponseDTO registerOrganisation(String name);
    public LesieResponseDTO registerApplication(String appName,String appDesc,String organisationName);
    public LesieResponseDTO registerUser(String globalKey,String name,String surname);
}

/*
TODO: Add API for retrieving list of all users and policies for given application
TODO: Add API for adding notifications, which basically serve as log of what is happening to user data
TODO: Re-design the connections between User,Policy,Application and Notification entities
TODO: Start writing
*/