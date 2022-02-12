package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.framework.WindowManager;
import com.pyredevelopment.engine.messaging.Message;

public class InputSystem extends SuperSystem {

    @Override
    public void startup() {
        WindowManager.initialize();
        WindowManager.newWindow();
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
}
