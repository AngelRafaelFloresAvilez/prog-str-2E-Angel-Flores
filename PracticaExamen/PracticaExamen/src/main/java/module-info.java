module utez.edu.mx.practicaexamen {
    requires javafx.controls;
    requires javafx.fxml;


    opens utez.edu.mx.practicaexamen to javafx.fxml;
    opens utez.edu.mx.practicaexamen.controllers to javafx.fxml;
    opens utez.edu.mx.practicaexamen.model to javafx.fxml;
    opens utez.edu.mx.practicaexamen.services to javafx.fxml;
    exports utez.edu.mx.practicaexamen;
    exports utez.edu.mx.practicaexamen.controllers;
    exports utez.edu.mx.practicaexamen.model;
    exports utez.edu.mx.practicaexamen.services;
}