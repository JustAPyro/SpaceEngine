package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.gameplay.GameState;

public class GameplaySystem extends SuperSystem {

    GameState game;

    @Override
    public void startup() {
        systemName = "Gameplay";

        Console.logln("(Gameplay) System: Launched");
    }

    @Override
    public void systemLoop() {

    }

    public void handleKeyUpdate(byte[] update) {

    }
}
