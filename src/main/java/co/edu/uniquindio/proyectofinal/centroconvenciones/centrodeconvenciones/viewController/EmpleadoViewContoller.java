package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.viewController;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controller.EmpleadoController;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.mapping.dto.EmpleadoDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class EmpleadoViewContoller {
    EmpleadoController empleadoControllerService;
    ObservableList<EmpleadoDto> listaEmpleadosDto = FXCollections.observableArrayList();
    EmpleadoDto empleadoSeleccionado;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableView<EmpleadoDto> tableEmpleados;

    @FXML
    private TableColumn<EmpleadoDto, String> tcEmail;

    @FXML
    private TableColumn<EmpleadoDto, String> tcEventoAsignado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcId;

    @FXML
    private TableColumn<EmpleadoDto, String> tcNombre;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEventoAsignado;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    void initialize() {
        empleadoControllerService = new EmpleadoController();
        intiView();


}
    private void intiView() {
        initDataBinding();
        obtenerEmpleados();
        tableEmpleados.getItems().clear();
        tableEmpleados.setItems(listaEmpleadosDto);
        listenerSelection();
    }

    private void initDataBinding() {
        tcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().id()));
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().email()));
        tcEventoAsignado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().eventosAsignados()));

    }

    private void obtenerEmpleados() {
        listaEmpleadosDto.addAll(empleadoControllerService.obtenerEmpleados());
    }

    private void listenerSelection() {
        tableEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            empleadoSeleccionado = newSelection;
            mostrarInformacionEmpleado(empleadoSeleccionado);
        });
    }

    private void mostrarInformacionEmpleado(EmpleadoDto empleadoSeleccionado) {
        if(empleadoSeleccionado != null){
            txtId.setText(empleadoSeleccionado.id());
            txtNombre.setText(empleadoSeleccionado.nombre());
            txtEmail.setText(empleadoSeleccionado.email());
            txtEventoAsignado.setText(empleadoSeleccionado.eventosAsignados());
        }


    }

    @FXML
    void nuevoEmpleadoAction(ActionEvent event) {
        txtId.setText("Ingrese el ID");
        txtNombre.setText("Ingrese el nombre");
        txtEmail.setText("Ingrese el email");
        txtEventoAsignado.setText("Ingrese el evento");

    }

    @FXML
    void agregarEmpleadoAction(ActionEvent event) {
        crearEmpleado();
    }

    @FXML
    void eliminarEmpleadoAction(ActionEvent event) {
        eliminarEmpleado();
    }


    @FXML
    void actualizarEmpleadoAction(ActionEvent event) {
        actualizarEmpleado();
    }

    private void crearEmpleado() {
        //1. Capturar los datos
        EmpleadoDto empleadoDto = construirEmpleadoDto();
        //2. Validar la información
        if(datosValidos(empleadoDto)){
            if(empleadoControllerService.agregarEmpleado(empleadoDto)){
                listaEmpleadosDto.add(empleadoDto);
                mostrarMensaje("Notificación empleado", "Empleado creado", "El empleado se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposEmpleado();
            }else{
                mostrarMensaje("Notificación empleado", "Empleado no creado", "El empleado no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }

    }

    private void eliminarEmpleado() {
        boolean empleadoEliminado = false;
        if(empleadoSeleccionado != null){
            if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar al empleado?")){
                empleadoEliminado = empleadoControllerService.eliminarEmpleado(empleadoSeleccionado.id());
                if(empleadoEliminado == true){
                    listaEmpleadosDto.remove(empleadoSeleccionado);
                    empleadoSeleccionado = null;
                    tableEmpleados.getSelectionModel().clearSelection();
                    limpiarCamposEmpleado();
                    mostrarMensaje("Notificación empleado", "Empleado eliminado", "El empleado se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                }else{
                    mostrarMensaje("Notificación empleado", "Empleado no eliminado", "El empleado no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        }else{
            mostrarMensaje("Notificación empleado", "Empleado no seleccionado", "Seleccionado un empleado de la lista", Alert.AlertType.WARNING);
        }
    }

    private void actualizarEmpleado() {
        boolean clienteActualizado = false;
        //1. Capturar los datos
        String id = empleadoSeleccionado.id();
        EmpleadoDto empleadoDto = construirEmpleadoDto();
        //2. verificar el empleado seleccionado
        if(empleadoSeleccionado != null){
            //3. Validar la información
            if(datosValidos(empleadoSeleccionado)){
                clienteActualizado = empleadoControllerService.actualizarEmpleado(id,empleadoDto);
                if(clienteActualizado){
                    listaEmpleadosDto.remove(empleadoSeleccionado);
                    listaEmpleadosDto.add(empleadoDto);
                    tableEmpleados.refresh();
                    mostrarMensaje("Notificación empleado", "Empleado actualizado", "El empleado se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposEmpleado();
                }else{
                    mostrarMensaje("Notificación empleado", "Empleado no actualizado", "El empleado no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }

        }
    }

    private EmpleadoDto construirEmpleadoDto() {
        return new EmpleadoDto(
                txtId.getText(),
                txtNombre.getText(),
                txtEmail.getText(),
                txtEventoAsignado.getText()
        );
    }

    private void limpiarCamposEmpleado() {
        txtId.setText("");
        txtNombre.setText("");
        txtEmail.setText("");
        txtEventoAsignado.setText("");

    }

    private boolean datosValidos(EmpleadoDto empleadoDto) {
        String mensaje = "";
        if(empleadoDto.id() == null || empleadoDto.id().equals(""))
            mensaje += "El ID es invalido \n" ;
        if(empleadoDto.nombre() == null || empleadoDto.nombre() .equals(""))
            mensaje += "El nombre es invalido \n" ;
        if(empleadoDto.email() == null || empleadoDto.email().equals(""))
            mensaje += "El email es invalido \n" ;
        if(empleadoDto.eventosAsignados() == null || empleadoDto.eventosAsignados().equals(""))
            mensaje += "La direccion es invalida \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }


}


