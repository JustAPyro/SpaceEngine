package com.pyredevelopment.engine.server;

import com.pyredevelopment.engine.game.GameState;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    private static final int PORT_NUMBER = 9875;
    private static DatagramSocket socket;

    public static void main(String[] args) {
        try {

            GameState game = new GameState();

            socket = new DatagramSocket(PORT_NUMBER);
            byte[] buf = new byte[1];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                try {
                    socket.receive(packet);
                    InetAddress address = packet.getAddress();
                    int port = packet.getPort();

                    String inputs = String.format("%07d", Integer.parseInt(Integer.toBinaryString(packet.getData()[0])));
                    System.out.println(inputs);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
