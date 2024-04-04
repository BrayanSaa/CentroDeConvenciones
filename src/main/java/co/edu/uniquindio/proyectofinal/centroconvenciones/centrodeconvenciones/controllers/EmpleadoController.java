package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controllers;

import static co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controllers.AppController.INSTANCE;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model.Empleado;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class EmpleadoController {
    @FXML
    private TableView<Empleado> tableEmpleados;
    @FXML
    private TableColumn<Empleado,String> tcId;
    @FXML
    private TableColumn<Empleado,String> tcNombre;
    @FXML
    private TableColumn<Empleado,String> tcEmail;
    @FXML
    private TableColumn<Empleado,String> tcEventoAsignado;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEventoAsignado;

    private Empleado empleadoSeleccionado;


    @FXML
    public void initialize(){
        llenarTabla(INSTANCE.getAdministrador().buscar(null,null,null));
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcEventoAsignado.setCellValueFactory(new PropertyValueFactory<>("evento"));
        tableEmpleados.getSelectionModel().selectedItemProperty()
                .addListener((observable,oldValue,newValue)->llenarCampo(newValue));

        empleadoSeleccionado=null;
    }

    private void llenarCampo(Empleado empleado){
        empleadoSeleccionado= empleado;
        if(empleado != null){
            txtId.setText(empleado.getID());
            txtNombre.setText(empleado.getNombre());
            txtEmail.setText(empleado.getCorreo());
            txtEventoAsignado.setText(empleado.getEventosString());
        }

    }

    private void llenarTabla(List<Empleado> empleados){
        tableEmpleados.setItems(FXCollections.observableArrayList(empleados));
        tableEmpleados.refresh();
    }
    public void buscarEmpleadoAction() {
        llenarTabla(
                INSTANCE.getAdministrador().buscar(txtId.getText(),txtNombre.getText(),txtEmail.getText())
                );
    }

    public void agregarEmpleadoAction() {
        try {
            Empleado empleado = Empleado.of(txtId.getText(),txtNombre.getText(),txtEmail.getText());
            INSTANCE.getAdministrador().registrarEmpleado(empleado);
            llenarTabla(INSTANCE.getAdministrador().buscar(null,null,null));
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }
    }

    private void mostrarMensaje(String message) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void eliminarEmpleadoAction(ActionEvent actionEvent) {

    }
    public void actualizarEmpleadoAction(ActionEvent actionEvent) {
    }
}