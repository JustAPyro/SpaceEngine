package com.pyredevelopment.engine.game;

import com.pyredevelopment.engine.messaging.MessageBus;
import com.pyredevelopment.engine.systems.RenderSystem;

import java.util.Scanner;

public class GameEngine {

    public static final boolean DEBUG = true;

    MessageBus messageBus;

    public GameEngine() {
        Console.log("Creating game engine instance...");

        // Create a new message bus
        messageBus = new MessageBus();

        // Launch all subsystems
        launchSystems();

        // if in debug mode, enter console
        if (DEBUG) Console.enterConsole();

    }

    /**
     * Handles launching all the systems
     */
    private void launchSystems() {
        Console.log(" - Starting Systems - ");
        messageBus.launch(new RenderSystem());

    }

}
