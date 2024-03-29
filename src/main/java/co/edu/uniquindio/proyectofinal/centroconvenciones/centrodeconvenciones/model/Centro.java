package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.exceptions.EmpleadoException;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model.services.ICentroService;

import java.util.ArrayList;

public class Centro implements ICentroService {
    private static final long serialVersionUID = 1L;
    //ArrayList<Cliente> listaClientes = new ArrayList<>();
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    public Centro(){

    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    @Override
    public Empleado crearEmpleado(String id, String nombre, String email, String eventosAsignados) throws EmpleadoException{
        Empleado nuevoEmpleado = null;
        boolean empleadoExiste = verificarEmpleadoExistente(id);
        if(empleadoExiste){
            throw new EmpleadoException("El empleado con cedula: "+id+" ya existe");
        }else{
            nuevoEmpleado = new Empleado();
            nuevoEmpleado.setId(id);
            nuevoEmpleado.setNombre(nombre);
            nuevoEmpleado.setEmail(email);
            nuevoEmpleado.setEventosAsignados(eventosAsignados);
            getListaEmpleados().add(nuevoEmpleado);
        }
        return nuevoEmpleado;
    }

    public void agregarEmpleado(Empleado nuevoEmpleado) throws EmpleadoException{
        getListaEmpleados().add(nuevoEmpleado);
    }

    @Override
    public boolean actualizarEmpleado(String id, Empleado empleado) throws EmpleadoException {
        Empleado empleadoActual = obtenerEmpleado(id);
        if(empleadoActual == null)
            throw new EmpleadoException("El empleado a actualizar no existe");
        else{
            empleadoActual.setId(empleado.getId());
            empleadoActual.setNombre(empleado.getNombre());
            empleadoActual.setEmail(empleado.getEmail());
            empleadoActual.setEventosAsignados(empleado.getEventosAsignados());

            return true;
        }
    }

    @Override
    public Boolean eliminarEmpleado(String id) throws EmpleadoException {
        Empleado empleado = null;
        boolean flagExiste = false;
        empleado = obtenerEmpleado(id);
        if(empleado == null)
            throw new EmpleadoException("El empleado a eliminar no existe");
        else{
            getListaEmpleados().remove(empleado);
            flagExiste = true;
        }
        return flagExiste;
    }

    @Override
    public boolean verificarEmpleadoExistente(String id) throws EmpleadoException {
        if(empleadoExiste(id)){
            throw new EmpleadoException("El empleado con id: "+id+" ya existe");
        }else{
            return false;
        }
    }

    @Override
    public Empleado obtenerEmpleado(String id) {
        Empleado empleadoEncontrado = null;
        for (Empleado empleado : getListaEmpleados()) {
            if(empleado.getCedula().equalsIgnoreCase(id)){
                empleadoEncontrado = empleado;
                break;
            }
        }
        return empleadoEncontrado;
    }

    @Override
    public ArrayList<Empleado> obtenerEmpleados() {
        // TODO Auto-generated method stub
        return getListaEmpleados();
    }

    public boolean empleadoExiste(String id) {
        boolean empleadoEncontrado = false;
        for (Empleado empleado : getListaEmpleados()) {
            if(empleado.getCedula().equalsIgnoreCase(id)){
                empleadoEncontrado = true;
                break;
            }
        }
        return empleadoEncontrado;
    }

}
