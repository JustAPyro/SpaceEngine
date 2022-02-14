package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.framework.WindowManager;
import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.messaging.Message;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.nio.ByteBuffer;

public class RenderSystem extends SuperSystem {

    @Override
    public void startup() {
        systemName = "Render";
        Console.logln("(Render) System: Launched");
        WindowManager.initialize();
        WindowManager.newWindow();
    }

    @Override
    public void systemLoop() {

    }

    public void shutdown() {
        WindowManager.end();
        super.close();
    }

    @Override
    public void handleGameState(Message msg) {
        Console.logln("(Render) Adjusting Game-state");
        Canvas canvas = WindowManager.getCanvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        byte[] inputs = msg.data();
        byte[] first = new byte[4];
        byte[] second = new byte[4];

        System.arraycopy(inputs, 0, first, 0, 4);
        System.arraycopy(inputs, 4, second, 0, 4);

        int xVal = ByteBuffer.wrap(first).getInt();
        int yVal = ByteBuffer.wrap(second).getInt();

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.fillRect(xVal-25, yVal-25, 50, 50);

    }

    @Override
    public void sendMessage(Message msg) {

    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
    }
}
