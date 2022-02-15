package com.pyredevelopment.engine.game;

import com.pyredevelopment.engine.messaging.Message;
import com.pyredevelopment.engine.messaging.MessageBus;
import com.pyredevelopment.engine.messaging.MessageType;
import com.pyredevelopment.engine.messaging.Open;

import java.util.Scanner;

public class Console {

    private static final boolean LOG_TO_CONSOLE = true;

    public static void enterConsole(MessageBus bus) {
        Console.logln("Entering Developer Console:");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = in.nextLine();

            // If we're shutting down
            if (input.equalsIgnoreCase("exit")) {
                bus.close();
                return;
            }
            else if (input.equalsIgnoreCase("quit")) {
                bus.postMessage(new Message(MessageType.SHUTDOWN));
                Console.logln("Shutting down Systems and exiting...");
                bus.close();
                return;
            }

            bus.postMessage(parseString(input));

        }
    }

    private static Message parseString(String message) {
        if (message.equalsIgnoreCase("Shutdown"))
            return new Message(MessageType.SHUTDOWN);

        if (message.equalsIgnoreCase("status"))
            return new Message(MessageType.STATUS);

        if (message.contains("gamestate")) {
            return parseGameState(message);
        }
        if (message.contains("open")) {
            return parseOpen(message);
        }

        return new Message(MessageType.EMPTY);
    }

    private static Message parseOpen(String string) {
        if (string.contains("main")) {
            return new Message(MessageType.OPEN, new byte[]{Open.MAIN});
        }
        Console.logln("Unknown OPEN command");
        return new Message(MessageType.EMPTY);
    }

    private static Message parseGameState(String string) {

        string = string.replaceAll("[^\\d]", " ");

        // Remove extra spaces from the beginning
        // and the ending of the string
        string = string.trim();

        // Replace all the consecutive white
        // spaces with a single space
        string = string.replaceAll(" +", " ");

        String[] nums = string.split(" ");

        if (nums.length != 2) {
            logln("Please provide 2 values when using game-state");
            return new Message(MessageType.EMPTY);
        }

        byte[] first = toBytes(Integer.parseInt(nums[0]));
        byte[] second = toBytes(Integer.parseInt(nums[1]));

        byte[] finalBytes = new byte[8];
        System.arraycopy(first, 0, finalBytes, 0, 4);
        System.arraycopy(second, 0, finalBytes, 4, 4);



        return new Message(MessageType.GAME_STATE, finalBytes);
    }

    private static byte[] toBytes(int i)
    {
        byte[] result = new byte[4];

        result[0] = (byte) (i >> 24);
        result[1] = (byte) (i >> 16);
        result[2] = (byte) (i >> 8);
        result[3] = (byte) (i /*>> 0*/);

        return result;
    }

    public static void logln(String message) {
        if (LOG_TO_CONSOLE)
            System.out.println(message);
    }

    public static void log(String message) {
        if (LOG_TO_CONSOLE)
            System.out.print(message);
    }

}
