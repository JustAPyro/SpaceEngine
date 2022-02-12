package com.pyredevelopment.engine.messaging;
import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.game.GameEngine;
import com.pyredevelopment.engine.systems.SuperSystem;

import java.util.ArrayList;

public class MessageBus {

    ArrayList<SuperSystem> systems;

    public MessageBus() {
        Console.log("Starting Message Bus...");

        // Create the array of all systems
        systems = new ArrayList<>();
    }

    public void launch(SuperSystem system) {
        systems.add(system);
        system.link(this);
    }

}
