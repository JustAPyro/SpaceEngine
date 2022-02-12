package com.pyredevelopment.engine.game;

import com.pyredevelopment.engine.messaging.MessageBus;
import com.pyredevelopment.engine.systems.InputSystem;
import com.pyredevelopment.engine.systems.LoadingSystem;
import com.pyredevelopment.engine.systems.RenderSystem;

public class GameEngine {

    public static final boolean DEBUG = true;

    MessageBus messageBus;

    public GameEngine() {
        Console.logln("Creating game engine instance.");

        // Create a new message bus
        messageBus = new MessageBus();

        // Launch all subsystems
        launchSystems();

        // if in debug mode, enter console
        if (DEBUG) Console.enterConsole(messageBus);

    }

    /**
     * Handles launching all the systems
     */
    private void launchSystems() {
        Console.logln("Starting Systems: ");
        messageBus.launch(new RenderSystem());

    }

}
