module com.hotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    requires mysql.connector.j;

    opens com.hotel to javafx.fxml;
    exports com.hotel;
}