package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.messaging.Message;

import java.io.IOException;
import java.net.*;

public class NetworkSystem extends SuperSystem {

    private final String IP_ADDRESS = "98.118.61.212";
    private final int PORT_NUMBER = 9875;

    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buffer;

    @Override
    public void startup() {
        systemName = "Network";

        try {
            socket = new DatagramSocket();
            address = InetAddress.getLocalHost();
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }

        Console.logln("(Network) System: Launched");
    }

    @Override
    public void systemLoop() {

    }

    @Override
    public void handleKeyUpdate(byte[] update) {
        buffer = update;
        DatagramPacket packetOut
                = new DatagramPacket(buffer, buffer.length, address, PORT_NUMBER);
        try {
            socket.send(packetOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shutdown() {
        super.close();
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

    }
}
