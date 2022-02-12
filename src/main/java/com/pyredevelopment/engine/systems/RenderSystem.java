package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.messaging.Message;
import com.pyredevelopment.engine.messaging.MessageType;

public class RenderSystem extends SuperSystem {

    @Override
    public void startup() {
        Console.log("Launching Render System... ");
        Console.logln("Success");
    }

    @Override
    public void systemLoop() {

    }

    public void shutdown() {
        super.close();
    }

    @Override
    public void sendMessage(Message msg) {

    }

    @Override
    public void handleMessage(Message msg) {
        if (msg.type() == MessageType.SHUTDOWN) {
            Console.logln("\b\bRender: Shutting down");
            Console.log("> ");
            shutdown();
        }
    }
}
