package com.pyredevelopment.engine.server;

import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ServerListener implements Runnable {

    private static final int PORT_NUMBER = 9875;
    private static DatagramSocket socket;
    private Set<KeyCode> keysPressed;
    private byte[] buf;

    public ServerListener() throws SocketException {
        keysPressed = Collections.synchronizedSet(new HashSet<>());
        socket = new DatagramSocket(PORT_NUMBER);
        buf = new byte[1];
    }


    @Override
    public void run() {
        while (true) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();


                String inputs = String.format("%07d", Integer.parseInt(Integer.toBinaryString(packet.getData()[0])));
                updateKeys(inputs);
                System.out.println(keysPressed.size());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateKeys(String keyString) {
        char[] bits = keyString.toCharArray();
        if (bits[0] == '1') keysPressed.add(KeyCode.W); else keysPressed.remove(KeyCode.W);
        if (bits[1] == '1') keysPressed.add(KeyCode.A); else keysPressed.remove(KeyCode.A);
        if (bits[2] == '1') keysPressed.add(KeyCode.S); else keysPressed.remove(KeyCode.S);
        if (bits[3] == '1') keysPressed.add(KeyCode.D); else keysPressed.remove(KeyCode.D);
    }

    public Set<KeyCode> getKeys() {
        return keysPressed;
    }
}
