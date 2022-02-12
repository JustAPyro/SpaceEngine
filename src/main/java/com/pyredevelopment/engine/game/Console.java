package com.pyredevelopment.engine.game;

import java.util.Scanner;

public class Console {

    private static final boolean LOG_TO_CONSOLE = true;

    public static void enterConsole() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            in.nextLine();
        }
    }

    public static void log(String message) {
        if (LOG_TO_CONSOLE)
            System.out.println("> " + message);
    }

}
