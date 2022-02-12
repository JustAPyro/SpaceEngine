package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.messaging.Message;
import com.pyredevelopment.engine.messaging.MessageBus;

public abstract class SuperSystem implements Runnable {

    private volatile boolean systemRunning = false;

    private MessageBus messageBus;

    public SuperSystem() {
        startup();
        Thread systemThread = new Thread(this);
        systemThread.start();
    }

    public void link(MessageBus messageBus) {
        this.messageBus = messageBus;
    }

    public abstract void startup();

    public abstract void systemLoop();

    public abstract void sendMessage(Message msg);

    public abstract void handleMessage(Message msg);

    @Override
    public void run() {
        systemRunning = true;
        while (systemRunning) {

        }
    }
}
