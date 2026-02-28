module com.example.logindashboardangelflores {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.logindashboardangelflores to javafx.fxml;
    opens com.example.logindashboardangelflores.controllers to javafx.fxml;


    exports com.example.logindashboardangelflores.controllers;
    exports com.example.logindashboardangelflores;
}