package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.messaging.Message;

public class SuperSystem implements Runnable {

    private volatile boolean systemRunning = false;

    public SuperSystem() {
        startup();
        Thread systemThread = new Thread(this);
        systemThread.start();
    }

    public void startup() {

    }

    public void systemLoop() {

    }

    public void sendMessage(Message msg) {

    }

    public void handleMessage(Message msg) {

    }

    @Override
    public void run() {
        systemRunning = true;
        while (systemRunning) {
            System.out.println("System running!");
        }
    }
}
