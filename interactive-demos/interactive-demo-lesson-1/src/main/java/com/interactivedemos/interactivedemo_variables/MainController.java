package com.interactivedemos.interactivedemo_variables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    private ComboBox comboBox;

    @FXML
    protected void onConvertButtonClick() {
        var userInput = Long.parseLong(decimalInput.getText());
        this.deciByteTable.getItems().add(new TableEntry(userInput, getNumberOfBits((String)comboBox.getValue())));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Configure the dropdown list
        ObservableList<String> observableList = FXCollections.observableArrayList("byte","short","int","long");
        comboBox.setItems(observableList);
        comboBox.setOnAction(actionEvent -> decimalInput.setText(""));
        comboBox.setValue("byte");

        // Rudimentary input validation.
        decimalInput.textProperty().addListener((observableValue, oldInput, input) -> {
          setConvertButtonProperties(input);
        });
    }

    private void setConvertButtonProperties(String input){
        if (input.isBlank()) {
            convertButton.setDisable(true);
            return;
        }
        try {
            String selectedType = (String) comboBox.getValue();
            convertButton.setDisable(false);
            var parsedInput = Long.parseLong(input);

            if (selectedType.equals("byte") && ( parsedInput > 127 || parsedInput < -127)) {
                convertButton.setDisable(true);
            }
            else if((selectedType.equals("short") || selectedType.equals("char"))
                    && parsedInput > 32767 || parsedInput < -32768){
                convertButton.setDisable(true);
            }
            else if((selectedType.equals("int"))
                    && parsedInput > 2147483647 || parsedInput < -2147483648){
                convertButton.setDisable(true);
            }
            else if((selectedType.equals("long"))
                    && parsedInput > 9223372036854775807L || parsedInput < -9223372036854775808L){
                convertButton.setDisable(true);
            }
        } catch (NumberFormatException nfe) {
            convertButton.setDisable(true);
        }
    }

    private byte getNumberOfBits(String dataType){
        switch (dataType){
            case "byte":
                return 8;
            case "short":
                return 16;
            case "int":
            case "long":
                return 64;
            default:
                return 0;
        }

    }
}