package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.framework.WindowManager;
import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.messaging.Message;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashSet;

public class InputSystem extends SuperSystem {

    // Hashset of keys currently pressed
    HashSet<KeyCode> keysPressed;

    @Override
    public void startup() {
        systemName = "Input";
        Scene scene = WindowManager.getScene();
        scene.setOnKeyPressed(this::keyPressed);
        scene.setOnKeyReleased(this::keyReleased);

        Console.logln("(Input) System: Launched");
    }

    private void keyReleased(KeyEvent e) {
        keysPressed.add(e.getCode());
    }

    private void keyPressed(KeyEvent e) {
        keysPressed.remove(e.getCode());
    }

    @Override
    public void systemLoop() {

    }

    @Override
    public void shutdown() {
        super.close();
    }

    @Override
    public void sendMessage(Message msg) {

    }
}
