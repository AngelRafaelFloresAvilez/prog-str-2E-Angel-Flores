package com.example.logindashboardangelflores.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FormController {
    @FXML
    private Label bienvenida;

    public void nombreUsuario (String nombre){
        bienvenida.setText("Bienvenido, " + nombre);
    }
}


