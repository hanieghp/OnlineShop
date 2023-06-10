module com.example.online {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.online to javafx.fxml;
    exports com.example.online;
}