package com.pyredevelopment.engine.messaging;
import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.systems.SuperSystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MessageBus implements Runnable{

    private volatile boolean busRunning = true;
    private Thread messageThread;
    private ArrayList<SuperSystem> systems;
    private ArrayBlockingQueue<Message> messageQueue;

    public MessageBus() {
        Console.logln("Starting Message Bus.");

        // Create the array of all systems
        systems = new ArrayList<>();

        // Create the queue of messages on the bus
        messageQueue = new ArrayBlockingQueue<>(50);

        // Create a thread using this class and start the loop
        messageThread = new Thread(this);
        messageThread.start();

    }

    synchronized public void postMessage(Message msg) {
        messageQueue.add(msg);
    }

    public void launch(SuperSystem system) {
        systems.add(system);
        system.link(this);
    }

    @Override
    public void run() {
        while (busRunning) {
            if (!messageQueue.isEmpty()) {
                propagateMessage(messageQueue.poll());
            }
        }
    }

    public void close() {
        busRunning = false;
    }

    private void propagateMessage(Message msg) {
        for (SuperSystem system : systems) {
            system.handleMessage(msg);
        }
    }
}
