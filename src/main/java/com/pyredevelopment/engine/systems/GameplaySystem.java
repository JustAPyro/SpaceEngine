package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.gameplay.GameState;
import javafx.scene.input.KeyCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GameplaySystem extends SuperSystem {

    GameState game;

    Set<KeyCode> keysPressed;

    @Override
    public void startup() {
        systemName = "Gameplay";
        keysPressed = Collections.synchronizedSet(new HashSet<>());
        Console.logln("(Gameplay) System: Launched");
    }

    @Override
    public void systemLoop() {

    }

    public void handleKeyUpdate(byte[] update) {
        String inputs = String.format("%07d", Integer.parseInt(Integer.toBinaryString(update[0])));
        updateKeys(inputs);
    }

    private void updateKeys(String keyString) {
        char[] bits = keyString.toCharArray();
        if (bits[0] == '1') keysPressed.add(KeyCode.W); else keysPressed.remove(KeyCode.W);
        if (bits[1] == '1') keysPressed.add(KeyCode.A); else keysPressed.remove(KeyCode.A);
        if (bits[2] == '1') keysPressed.add(KeyCode.S); else keysPressed.remove(KeyCode.S);
        if (bits[3] == '1') keysPressed.add(KeyCode.D); else keysPressed.remove(KeyCode.D);
    }
}
