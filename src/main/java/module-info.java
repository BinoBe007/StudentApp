module com.mycompany.studentapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.studentapp to javafx.fxml;
    exports com.mycompany.studentapp;
}
