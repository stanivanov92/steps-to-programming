package com.interactivedemos.interactivedemo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.setProperty("prism.text", "t2k");
        System.setProperty("prism.lcdtext", "true");

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 390, 240);
        stage.setTitle("Interactive Demo 1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}