package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model.services;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.exceptions.EmpleadoException;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model.Empleado;


import java.util.ArrayList;

public interface ICentroService {
    public Empleado crearEmpleado(String id, String nombre, String email, String eventoAsignado) throws EmpleadoException;
    public Boolean eliminarEmpleado(String id)throws EmpleadoException;
    boolean actualizarEmpleado(String id, Empleado empleado) throws EmpleadoException;
    public boolean  verificarEmpleadoExistente(String id) throws EmpleadoException;
    public Empleado obtenerEmpleado(String id);
    public ArrayList<Empleado> obtenerEmpleados();

}
