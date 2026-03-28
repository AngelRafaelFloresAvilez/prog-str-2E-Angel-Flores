package utez.edu.mx.practicaexamen.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import utez.edu.mx.practicaexamen.model.Contacto;
import utez.edu.mx.practicaexamen.services.ContactService;

public class ContactController {
    private String[] arrParentescos = {
            "Padre" ,
            "Madre" ,
            "Hermano" ,
            "Hermana" ,
            "Abuelo" ,
            "Abuela" ,
            "Tio" ,
            "Tia"
    };
    @FXML
    private Label lblInfo;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtTel;
    @FXML
    private ComboBox<String> cbParentescos;
    @FXML
    private ListView<Contacto> listViewContacts;

    private ObservableList<String> listObservableParent = FXCollections.observableArrayList();
    private ContactService service = new ContactService();
    private ObservableList<Contacto> listObservableContacts = FXCollections.observableArrayList();


    @FXML
    public void initialize(){
        listObservableParent.setAll(arrParentescos);
        cbParentescos.setItems(listObservableParent);

        listViewContacts.getSelectionModel().selectedItemProperty().addListener
                ((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtName.setText(newValue.getName());
                txtTel.setText(newValue.getTel());
                cbParentescos.setValue(newValue.getParent());
            }
        });
    }
    @FXML
    public void onAddContact(){
        if (!validarCampos()) {
            return;
        }
        String name = txtName.getText().trim();
        String tel = txtTel.getText();
        String parent = cbParentescos.getValue();
        Contacto contact = new Contacto(name, tel, parent);
        service.addContact(contact);
        listObservableContacts.setAll(service.getAllContacts());
        listViewContacts.setItems(listObservableContacts);
        System.out.println(service.getAllContacts());

        lblInfo.setStyle("-fx-text-fill: green");
        lblInfo.setText("Contacto añadido");
    }
    public void onCleanContact(){
        txtName.clear();
        txtTel.clear();
        cbParentescos.setItems(null);
        cbParentescos.setItems(listObservableParent);
        listViewContacts.getSelectionModel().clearSelection();
        lblInfo.setStyle("-fx-text-fill: green");
        lblInfo.setText("Campos limpiados");
    }
    @FXML
    public void onDeleteContact() {
        Contacto selectedContact = listViewContacts.getSelectionModel().getSelectedItem();

        if (selectedContact != null) {
            service.deleteContact(selectedContact);
            listObservableContacts.setAll(service.getAllContacts());
            listViewContacts.setItems(listObservableContacts);
            txtName.clear();
            txtTel.clear();
            cbParentescos.setItems(null);
            lblInfo.setStyle("-fx-text-fill: green");
            lblInfo.setText("Contacto eliminado");
        } else {
            lblInfo.setStyle("-fx-text-fill: red");
            lblInfo.setText("Error: Debes seleccionar un contacto de la lista para borrarlo.");
        }
    }

    @FXML
    public void onUpdateContact() {
        Contacto seleccionado = listViewContacts.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            String nuevoNombre = txtName.getText().trim();
            String nuevoTel = txtTel.getText();
            String nuevoParent = cbParentescos.getValue();
            Contacto contactoActualizado = new Contacto(nuevoNombre, nuevoTel, nuevoParent);

            service.updateContact(seleccionado, contactoActualizado);

            listObservableContacts.setAll(service.getAllContacts());
            listViewContacts.setItems(listObservableContacts);

            onCleanContact();
            lblInfo.setStyle("-fx-text-fill: green");
            lblInfo.setText("Contacto actualizado");
        } else {
            lblInfo.setStyle("-fx-text-fill: red");
            lblInfo.setText("Error: Selecciona un contacto de la lista para editar");
        }
    }
    @FXML
    public void onRequestContact() {
        String nombreBusqueda = txtName.getText().trim();

        if (!nombreBusqueda.isEmpty()) {
            Contacto encontrado = service.findByName(nombreBusqueda);

            listViewContacts.getSelectionModel().select(encontrado);

            if (encontrado != null) {
                txtTel.setText(encontrado.getTel());
                cbParentescos.setValue(encontrado.getParent());
                lblInfo.setStyle("-fx-text-fill: green");
                lblInfo.setText("Contacto encontrado: " + encontrado.getName());
            } else {
                lblInfo.setStyle("-fx-text-fill: red");
                lblInfo.setText("No se encontró ningún contacto con ese nombre");
            }
        } else {
            lblInfo.setStyle("-fx-text-fill: red");
            lblInfo.setText("Escribe un nombre en el campo para poder buscar");
        }
    }
    private boolean validarCampos() {
        String nombre = txtName.getText().trim();
        String tel = txtTel.getText().trim();
        String parent = cbParentescos.getValue();

        if (nombre.isEmpty() || tel.isEmpty()) {
            lblInfo.setStyle("-fx-text-fill: red");
            lblInfo.setText("Error: El nombre y el teléfono son obligatorios");
            return false;
        }

        if (tel.length() != 10) {
            lblInfo.setStyle("-fx-text-fill: red");
            lblInfo.setText("Error: El teléfono debe tener exactamente 10 dígitos numéricos");
            return false;
        }

        if (parent == null || parent.isEmpty()) {
            lblInfo.setStyle("-fx-text-fill: red");
            lblInfo.setText("Error: Debes seleccionar un parentesco");
            return false;
        }

        if (service.findByName(nombre) != null) {
            lblInfo.setStyle("-fx-text-fill: red");
            lblInfo.setText("Error: Ya existe un contacto con el nombre '\" + nombre + \"'.\"");
            return false;
        }
        return true;
    }
}