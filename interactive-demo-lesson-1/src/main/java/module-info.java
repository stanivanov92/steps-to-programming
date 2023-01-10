module com.interactivedemos.interactivedemo_lesson1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.interactivedemos.interactivedemo_variables to javafx.fxml;
    exports com.interactivedemos.interactivedemo_variables;
    exports com.interactivedemos.interactivedemo_operators;
}