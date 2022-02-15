package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.messaging.Message;
import com.pyredevelopment.engine.messaging.MessageType;

public class LoadingSystem extends SuperSystem {
    @Override
    public void startup() {
        systemName = "Loading";

        Console.logln("(Loading) System: Launched");
    }

    @Override
    public void systemLoop() {

    }


    @Override
    public void sendMessage(Message msg) {

    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
    }
}
