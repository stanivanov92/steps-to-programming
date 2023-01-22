package com.interactivedemos.interactivedemo_variables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private ComboBox<String> comboBox;


    @FXML
    private TableView deciByteTable;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Rudimentary input validation.
        comboBox.getItems().addAll("byte","short","int","long","double","float", "char","boolean");
        comboBox.setValue("byte");
        comboBox.setOnAction(actionEvent -> {
        });
        setInitialTableSize(8);
    }

    private void setInitialTableSize(int columns) {
        for(int i = 0; i < columns; i++){
            final int j = i;
            TableColumn tableColumn = new TableColumn(String.valueOf((columns-1)-i));
            tableColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> {
                try {
                    var property = new SimpleStringProperty(param.getValue().get(j).toString());
                    return property;
                } catch (IndexOutOfBoundsException ioobe) {
                    throw new RuntimeException("The row input value length does not match the number of table columns", ioobe);
                }
            });
            deciByteTable.getColumns().addAll(tableColumn);
        }
        addRow("00000001");
    }


    private void addRow(String values ){
        ObservableList<String> row = FXCollections.observableArrayList();
        for (int i = 0; i < values.length(); i++) {
            row.addAll(String.valueOf(values.charAt(i)));
        }
        deciByteTable.getItems().add(row);
    }
}