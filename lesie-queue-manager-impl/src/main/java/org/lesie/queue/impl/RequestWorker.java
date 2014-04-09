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

package org.lesie.queue.impl;

import org.lesie.queue.LesieQueue;
import org.lesie.queue.QueueRequestObject;

import java.util.concurrent.Callable;

public class RequestWorker implements Callable<String> {

    private LesieQueue inQueue;

    private QueueRequestObject queueRequestObject;

    public RequestWorker(LesieQueue inQueue){
        this.inQueue = inQueue;
    }

    @Override
    public String call() throws Exception {
        return null;
    }
}
