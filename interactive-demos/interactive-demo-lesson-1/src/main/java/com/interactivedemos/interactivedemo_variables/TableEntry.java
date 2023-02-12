package com.interactivedemos.interactivedemo_variables;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableEntry {
    private final SimpleLongProperty decimalRepresentation;
    private final SimpleStringProperty binaryRepresentation;

    private final SimpleIntegerProperty numberOfBitsRepresentation;

    public TableEntry(Long decimal, byte numberOfBits) {
        this.decimalRepresentation = new SimpleLongProperty(decimal);

        this.numberOfBitsRepresentation = new SimpleIntegerProperty(numberOfBits);
        // Reference: https://stackoverflow.com/a/17496691
        var byteStringRepresentation = Long.toBinaryString((decimal));
        if(decimal < 0){
          byteStringRepresentation =  byteStringRepresentation.substring(64-numberOfBits,64);
        }
        this.binaryRepresentation = new SimpleStringProperty(byteStringRepresentation);
    }

    // ========= DO NOT DELETE - IN USE BY JAVAFX FXML =========

    public SimpleLongProperty decimalRepresentationProperty() {
        return decimalRepresentation;
    }

    public SimpleIntegerProperty numberOfBitsRepresentationProperty(){return numberOfBitsRepresentation;}

    public SimpleStringProperty binaryRepresentationProperty() {
        return binaryRepresentation;
    }
}
