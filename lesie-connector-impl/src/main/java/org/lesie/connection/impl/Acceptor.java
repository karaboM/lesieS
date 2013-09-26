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

package org.lesie.connection.impl;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

class Acceptor implements Runnable {
    private ServerSocketChannel serverSocketChannel;

    private Selector selector;

    public Acceptor(){};

    public Acceptor(ServerSocketChannel serverSocketChannel){
        this.serverSocketChannel = serverSocketChannel;
    }

    public void run() {
        try {

            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {

                new Handler(selector, socketChannel);
            }
            System.out.println("Connection Accepted by Reactor");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void setServerSocketChannel(ServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }

    void setSelector(Selector selector) {
        this.selector = selector;
    }
}