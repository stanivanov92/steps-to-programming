module com.interactivedemos.interactivedemo1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.interactivedemos.interactivedemo1 to javafx.fxml;
    exports com.interactivedemos.interactivedemo1;
}