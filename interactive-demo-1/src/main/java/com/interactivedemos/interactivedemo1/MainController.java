package com.interactivedemos.interactivedemo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TextField decimalInput;

    @FXML
    private Button convertButton;

    @FXML
    private TableView<TableEntry> deciByteTable;

    @FXML
    protected void onConvertButtonClick() {
        var userInput = Integer.parseInt(decimalInput.getText());
        this.deciByteTable.getItems().add(new TableEntry(userInput, (byte)userInput));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Rudimentary input validation.
        decimalInput.textProperty().addListener((observableValue, oldInput, input) -> {
            if (input.isBlank()) {
                convertButton.setDisable(true);
                return;
            }

            try {
                convertButton.setDisable(false);
                var parsedInput = Integer.parseInt(input);

                if (parsedInput > 127 || parsedInput < -127) {
                    convertButton.setDisable(true);
                }
            } catch (NumberFormatException nfe) {
                convertButton.setDisable(true);
            }
        });
    }
}