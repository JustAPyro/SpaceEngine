package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.messaging.Message;

public class RenderSystem extends SuperSystem {

    @Override
    public void startup() {
        Console.log("Launched Render System");
    }

    @Override
    public void systemLoop() {

    }

    @Override
    public void sendMessage(Message msg) {

    }

    @Override
    public void handleMessage(Message msg) {

    }
}
