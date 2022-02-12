package com.pyredevelopment.engine.game;

public class GameEngine {

    public static final boolean DEBUG = true;

    public GameEngine() {
        console("> Starting game engine instance...");

    }

    public static void console(String message) {
        if (DEBUG) System.out.println(message);
    }

}
