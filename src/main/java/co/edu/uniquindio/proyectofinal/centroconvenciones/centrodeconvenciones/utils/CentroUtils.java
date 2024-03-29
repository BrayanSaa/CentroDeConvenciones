package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.utils;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model.Centro;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model.Empleado;

public class CentroUtils {

    public static Centro inicializarDatos() {
        Centro centro = new Centro();
        Empleado empleado= new Empleado();
        empleado.setId("12345");
        empleado.setNombre("Jefferson B");
        empleado.setEmail("Jeff2002@gmail.com");
        empleado.setEventosAsignados("Fiesta");
        centro.getListaEmpleados().add(empleado);

//        Cliente cliente = new Cliente();
//        cliente.setNombre("juan");
//        cliente.setApellido("arias");
//        cliente.setCedula("125454");
//        cliente.setDireccion("Armenia");
//        cliente.setCorreo("uni1@");
//        cliente.setFechaNacimiento("12454");
//        cliente.setTelefono("125444");
//        banco.getListaClientes().add(cliente);
//
//        cliente = new Cliente();
//        cliente.setNombre("Pedro");
//        cliente.setApellido("Perez");
//        cliente.setCedula("77787");
//        cliente.setDireccion("Pererira");
//        cliente.setCorreo("uni2@");
//        cliente.setFechaNacimiento("12454");
//        cliente.setTelefono("125444");
//        banco.getListaClientes().add(cliente);
        return centro;
    }
}
