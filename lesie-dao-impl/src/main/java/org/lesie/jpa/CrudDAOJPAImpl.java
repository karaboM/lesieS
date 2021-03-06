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

package org.lesie.jpa;

import org.lesie.data.CrudDAO;

import javax.persistence.EntityManager;
import java.util.List;

public class CrudDAOJPAImpl<K,T> implements CrudDAO<K,T>{

    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(T newInstance) {
        em.persist(newInstance);

        em.flush();
     }

    @Override
    public T get(K Id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(T instance) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(T instance) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T getByProperty(String propertyName, String PropertyValue) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> getAllByProperty(String propertyName, String PropertyValue) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
