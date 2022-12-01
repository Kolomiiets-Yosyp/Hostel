module com.hotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    requires mysql.connector.j;
    requires java.desktop;

    opens com.hotel to javafx.fxml;
    exports com.hotel;
}