package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.messaging.Message;
import com.pyredevelopment.engine.messaging.MessageBus;
import com.pyredevelopment.engine.messaging.MessageType;

public abstract class SuperSystem implements Runnable {

    private volatile boolean systemRunning = false;

    String systemName = "UNKNOWN_SYSTEM";

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

    public abstract void shutdown();


    public void sendMessage(Message msg) {
        messageBus.postMessage(msg);
    }

    public void handleKeyUpdate(byte[] update) {}

    public void handleGameState(Message msg) {}

    public void handleOpen(Message msg) {}

    public void handleMessage(Message msg) {
        if (msg.type() == MessageType.SHUTDOWN) {
            Console.logln("\b\b(" + systemName + ") Shutting down");
            Console.log("> ");
            shutdown();
        }
        if (msg.type() == MessageType.STATUS) {
            Console.logln("\b\b(" + systemName + ") Responding");
            Console.log("> ");
        }
        if (msg.type() == MessageType.KEY_UPDATE) {
            handleKeyUpdate(msg.data());
        }
        if (msg.type() == MessageType.GAME_STATE) {
            handleGameState(msg);
        }
        if (msg.type() == MessageType.OPEN) {
            handleOpen(msg);
        }
    }

    @Override
    public void run() {
        systemRunning = true;
        while (systemRunning) {

        }
    }

    protected void close() {
        systemRunning = false;
    }
}
