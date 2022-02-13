package com.pyredevelopment.engine.game;

import javafx.scene.input.KeyCode;

import java.util.Set;

public class GameState {

    double playerX = 250;
    double playerY = 250;
    double speed = 0.001;

    public void update(Set<KeyCode> keys) {
        if (keys.contains(KeyCode.W) ^ keys.contains(KeyCode.S)) {
            if (keys.contains(KeyCode.W))
                playerY += speed;
            else
                playerY -= speed;
        }
        if (keys.contains(KeyCode.A) ^ keys.contains (KeyCode.D)) {
            if (keys.contains(KeyCode.A))
                playerX -= speed;
            else
                playerX += speed;
        }

        System.out.println("X: " + (int) playerX + " | Y: " + (int) playerY);
    }

    public byte[] encodeGameState() {
        byte[] outgoing = new byte[8];
        byte[] x = encodeInt((int) playerX);
        byte[] y = encodeInt((int) playerY);
        outgoing[0] = x[0];
        outgoing[1] = x[1];
        outgoing[2] = x[2];
        outgoing[3] = x[3];
        outgoing[4] = y[0];
        outgoing[5] = y[1];
        outgoing[6] = y[2];
        outgoing[7] = y[3];
        return outgoing;
    }

    public static byte[] encodeInt(int data) {

            return new byte[] {
                    (byte)((data >> 24) & 0xff),
                    (byte)((data >> 16) & 0xff),
                    (byte)((data >> 8) & 0xff),
                    (byte)((data >> 0) & 0xff),
            };

    }


}
