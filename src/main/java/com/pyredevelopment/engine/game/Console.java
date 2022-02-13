package com.pyredevelopment.engine.game;

import com.pyredevelopment.engine.messaging.Message;
import com.pyredevelopment.engine.messaging.MessageBus;
import com.pyredevelopment.engine.messaging.MessageType;

import java.util.Locale;
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

            bus.postMessage(parseString(input));

        }
    }

    private static Message parseString(String message) {
        if (message.equalsIgnoreCase("Shutdown"))
            return new Message(MessageType.SHUTDOWN);

        if (message.equalsIgnoreCase("status"))
            return new Message(MessageType.STATUS);

        if (message.contains("gamestate")) {
            return new Message(MessageType.EMPTY);
        }

        return new Message(MessageType.EMPTY);
    }

    private static Message parseGameState(String string) {
        char[] characters = string.toCharArray();
        return new Message(MessageType.EMPTY);
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
