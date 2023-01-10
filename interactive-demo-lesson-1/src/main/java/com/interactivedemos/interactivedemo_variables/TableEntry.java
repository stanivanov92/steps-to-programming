package com.interactivedemos.interactivedemo_variables;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableEntry {
    private final SimpleIntegerProperty decimalRepresentation;
    private final SimpleStringProperty binaryRepresentation;

    public TableEntry(Integer decimal, byte binary) {
        this.decimalRepresentation = new SimpleIntegerProperty(decimal);

        // Reference: https://stackoverflow.com/a/17496691
        var byteStringRepresentation = Integer.toBinaryString((binary & 0xFF) + 0x100).substring(1);
        this.binaryRepresentation = new SimpleStringProperty(byteStringRepresentation);
    }

    // ========= DO NOT DELETE - IN USE BY JAVAFX FXML =========

    public SimpleIntegerProperty decimalRepresentationProperty() {
        return decimalRepresentation;
    }

    public SimpleStringProperty binaryRepresentationProperty() {
        return binaryRepresentation;
    }
}
