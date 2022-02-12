package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.messaging.Message;
import com.pyredevelopment.engine.messaging.MessageType;

public class LoadingSystem extends SuperSystem {
    @Override
    public void startup() {
        Console.logln("(Loading) System: Launched");
    }

    @Override
    public void systemLoop() {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void sendMessage(Message msg) {

    }

    @Override
    public void handleMessage(Message msg) {
        if (msg.type() == MessageType.SHUTDOWN) {
            Console.logln("\b\b(Loader) Shutting down");
            Console.log("> ");
            shutdown();
        }
        if (msg.type() == MessageType.STATUS) {
            Console.logln("\b\b(Loader) Running");
            Console.log("> ");
        }
    }
}
