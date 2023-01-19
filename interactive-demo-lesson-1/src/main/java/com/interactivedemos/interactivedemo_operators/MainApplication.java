package com.interactivedemos.interactivedemo_operators;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Prevent text colour fringing
        System.setProperty("prism.text", "t2k");
        System.setProperty("prism.lcdtext", "true");

        // Specify which FXML file to load.
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-window.fxml"));
        // Set window size and scene.
        Scene scene = new Scene(fxmlLoader.load(), 550, 240);
        // Set window title.
        stage.setTitle("Interactive Demo - Operators");
        // Set scene to display in window.
        stage.setScene(scene);
        // Show window.
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}