package com.example.logindashboardangelflores.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
public class HomeController {
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtContra;
    @FXML
    private Label lblVa;
    @FXML

    public void onValidate (ActionEvent event) throws Exception {
        String usuario = txtUsuario.getText() == null ? "" : txtUsuario.getText();
        String correo = txtCorreo.getText() == null ? "" : txtCorreo.getText();
        String password = txtContra.getText() == null ? "" : txtContra.getText();

        List<String> errores = new ArrayList<>();

        if(usuario.trim().isEmpty() || usuario.length() < 4){
            errores.add("Usuario incorrecto");
        }
        if(correo.trim().isEmpty() || !correo.contains("@") || !correo.contains(".")){
            errores.add("Correo incorrecto");
        }
        if(password.trim().isEmpty() || password.length() < 6){
            errores.add("Contraseña incorrecta");
        }
        if(errores.isEmpty()){
            // Comando para entrar a la siguiente ventana que se me ocurrio
            continuarBoton(usuario);
        }else{
            String erroresLabel = "";
            for(String string : errores){
                erroresLabel += " / " + string;
            }
            lblVa.setText(erroresLabel);
            lblVa.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    private void continuarBoton(String usuario) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/logindashboardangelflores/form-view.fxml"));
        // Este fragmento lo tuve que investigar pq no sabia como cargar la siguiente ventana
        VBox root = loader.load();
        FormController controller = loader.getController();
        controller.nombreUsuario(usuario);
        Scene scene = new Scene(root);
        Stage stage = (Stage) lblVa.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Bienvenido");
        stage.show();
    }
}