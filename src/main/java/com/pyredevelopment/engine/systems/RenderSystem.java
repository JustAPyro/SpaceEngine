package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.framework.WindowManager;
import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.messaging.Message;
import com.pyredevelopment.engine.messaging.MessageType;

public class RenderSystem extends SuperSystem {

    @Override
    public void startup() {
        systemName = "Render";
        Console.logln("(Render) System: Launched");
        WindowManager.initialize();
        WindowManager.newWindow();
    }

    @Override
    public void systemLoop() {

    }

    public void shutdown() {
        WindowManager.end();
        super.close();
    }

    @Override
    public void handleGameState(Message msg) {
        Console.logln("(Render) Adjusting Game-state");
    }

    @Override
    public void sendMessage(Message msg) {

    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
    }
}
