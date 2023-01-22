package com.interactivedemos.interactivedemo_variables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
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

    private void setInitialTableSize(int columns){
        for(int i = 0; i < columns; i++){
            final int k = i;
            TableColumn<ObservableList<String>,String> tableColumn = new TableColumn(String.valueOf(i));
            tableColumn.setCellValueFactory(
                    (Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>)
                            param -> new SimpleStringProperty(param.getValue().get(k).toString()));
            deciByteTable.getColumns().add(tableColumn);
        }
        addRow("00000000");

    }


    private void addRow(String values ){
        ObservableList<String> row = FXCollections.observableArrayList(values);
        deciByteTable.getItems().add(row);
    }
}