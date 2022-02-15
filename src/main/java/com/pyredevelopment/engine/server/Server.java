package com.pyredevelopment.engine.server;

import com.pyredevelopment.engine.game.GameState;
import javafx.animation.AnimationTimer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    private static final int PORT_NUMBER = 9875;
    private static DatagramSocket socket;

    public static void main(String[] args) throws SocketException {

        ServerListener listener = new ServerListener();
        Thread t = new Thread(listener);
        t.start();

        GameState game = new GameState();

        AnimationTimer tm = new AnimationTimer() {
            @Override
            public void handle(long l) {
            }
        };

        while (true) {
            game.update(listener.getKeys());
        }

    }
}
