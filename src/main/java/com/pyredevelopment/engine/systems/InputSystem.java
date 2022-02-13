package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.framework.WindowManager;
import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.messaging.Message;
import com.pyredevelopment.engine.messaging.MessageType;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashSet;

public class InputSystem extends SuperSystem {

    // Hashset of keys currently pressed
    HashSet<KeyCode> keysPressed;

    // String builder to encode key data
    static StringBuilder byteBuilder;

    @Override
    public void startup() {
        systemName = "Input";
        keysPressed = new HashSet<>();
        byteBuilder = new StringBuilder();

        Scene scene = WindowManager.getScene();
        scene.setOnKeyPressed(this::keyPressed);
        scene.setOnKeyReleased(this::keyReleased);

        Console.logln("(Input) System: Launched");
    }

    private void updateKeyStatus() {
        sendMessage(new Message(MessageType.KEY_UPDATE, encodeKeys(keysPressed)));
    }

    private void keyReleased(KeyEvent e) {
        keysPressed.add(e.getCode());
        updateKeyStatus();
    }

    private void keyPressed(KeyEvent e) {
        keysPressed.remove(e.getCode());
        updateKeyStatus();
    }

    @Override
    public void systemLoop() {

    }

    @Override
    public void shutdown() {
        super.close();
    }

    public static byte[] encodeKeys(HashSet<KeyCode> keySet) {
        byteBuilder.setLength(0);
        byteBuilder.append("+");
        byteBuilder.append((keySet.contains(KeyCode.W) ? "0" : "1"));
        byteBuilder.append((keySet.contains(KeyCode.A) ? "0" : "1"));
        byteBuilder.append((keySet.contains(KeyCode.S) ? "0" : "1"));
        byteBuilder.append((keySet.contains(KeyCode.D) ? "0" : "1"));
        byteBuilder.append("000");
        return new byte[]{Byte.parseByte(byteBuilder.toString(), 2)};

    }
}
