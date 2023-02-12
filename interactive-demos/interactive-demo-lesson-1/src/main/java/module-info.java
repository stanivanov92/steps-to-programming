module com.interactivedemos.interactivedemo_lesson1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.interactivedemos.interactivedemo_variables to javafx.fxml;
    opens com.interactivedemos.interactivedemo_operators to javafx.fxml;
    exports com.interactivedemos.interactivedemo_variables;
    exports com.interactivedemos.interactivedemo_operators;
    exports com.interactivedemos.interactivedemo_operators.gui;
    opens com.interactivedemos.interactivedemo_operators.gui to javafx.fxml;
    exports com.interactivedemos.interactivedemo_operators.operators.standard;
    opens com.interactivedemos.interactivedemo_operators.operators.standard to javafx.fxml;
    exports com.interactivedemos.interactivedemo_operators.operators.combined;
    opens com.interactivedemos.interactivedemo_operators.operators.combined to javafx.fxml;
}