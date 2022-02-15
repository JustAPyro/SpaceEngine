package com.pyredevelopment.engine.systems;

import com.pyredevelopment.engine.framework.WindowManager;
import com.pyredevelopment.engine.game.Console;
import com.pyredevelopment.engine.messaging.Message;
import com.pyredevelopment.engine.messaging.Open;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

public class RenderSystem extends SuperSystem {

    Image ship;

    @Override
    public void startup() {
        systemName = "Render";
        Console.logln("(Render) System: Launched");
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream("src/main/resources/images/ship.png");
            ship = new Image(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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
        gc.drawImage(ship, xVal-50, yVal-50, 100, 100);

    }

    public void handleOpen(Message msg) {
        if (msg.data()[0] == Open.MAIN)
            drawMainMenu();
    }

    private void drawMainMenu() {
        Canvas canvas = WindowManager.getCanvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Font font = Font.loadFont("file:src/main/resources/fonts/menufont.ttf", 35);

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFill(Color.AQUA);
        gc.setFont(font);
        gc.fillText("NEW GAME", canvas.getWidth()/2, 100);
        gc.fillText("LOAD GAME", canvas.getWidth()/2, 150);
        gc.fillText("OPTIONS", canvas.getWidth()/2, 200);
        gc.fillText("EXIT", canvas.getWidth()/2, 250);

    }

    @Override
    public void sendMessage(Message msg) {

    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
    }
}
