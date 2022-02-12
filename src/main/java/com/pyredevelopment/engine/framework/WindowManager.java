package com.pyredevelopment.engine.framework;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;

/**
 * This is a primarily static class that handles all the back end and JavaFX Thread for the Window object wrappers.
 * <b><u>YOU ARE RECOMMENDED AGAINST USING THIS CLASS DIRECTLY</u></b>
 */
public class WindowManager extends Application{

    // This is a volatile flag indicating if the JFX toolkit is instantiated
    private static volatile boolean javaFxActive = false;
    private static volatile boolean windowCreated = false;

    // This allows Window objects to pass themselves in to indicate which stage they want to modify
    private static final HashMap<Stage, Canvas> canvases = new HashMap<>();

    private static Scene scene;

    /**
     * This has to be called before any other WindowManager functions can be called,
     * it will initialize the JavaFX Thread and prepare the class to manage Stage-Window interactions.
     * NOTE: If for some reason this fails, following methods may DeadLock trying to access specific Stages
     */
    public static void initialize()
    {
        // Create a new thread and launch the JFX application on it
        Thread t = new Thread(Application::launch);

        // Start the thread
        t.start();
    }

    /**
     * This allows the Window wrapper class to create a new Stage
     */
    public static void newWindow() {

        // Wait for the volatile flag to be true
        while (!javaFxActive)
            Thread.onSpinWait();

        // Run this on the JavaFX Thread whenever possible
        Platform.runLater(() -> {
            Stage stage = new Stage();      // Create a new stage

            VBox root = new VBox();
            Canvas canvas = new Canvas(500, 500);
            canvases.put(stage, canvas);
            root.getChildren().add(canvas);

            scene = new Scene(root);
            stage.setScene(scene);    // Set the root into the scene
            stage.show();                       // Set it to display
            windowCreated = true;
        });

    }

    public static Scene getScene() {
        // Wait for the volatile flag to be true
        while (!windowCreated)
            Thread.onSpinWait();

        return scene;
    }


    // - - - - - - - - - - Overridden Methods - - - - - - - - - -

    /**
     * Entry point for the JavaFX Thread. This tells the JavaFX to remain open and waiting to handle any other functions
     * @param stage The stage provided by default
     */
    @Override
    public void start(Stage stage) {
        // Set the javaFX thread/toolkit to remain open ad set our flag to true
        Platform.setImplicitExit(false);
        javaFxActive = true;
    }

}
