package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.utils.EmpleadoBusquedaUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
public class Administrador {
    private final String nombre;
    private final List<Empleado> empleados;

    public Administrador(String nombre) {
        this.nombre = nombre;
        empleados = new ArrayList<>();
    }

    public void registrarEmpleado(Empleado nuevoEmpleado) {
        if (buscarEmpleado(nuevoEmpleado.getID()).isPresent()) {
            System.out.println("Existente... pendiente exception");
        }
        empleados.add(nuevoEmpleado);
    }

    public Optional<Empleado> buscarEmpleado(String id) {
        return empleados.stream()
                .filter(estudiante -> estudiante.getID().equals(id))
                .findFirst();
    }

    public List<Empleado> buscar(String id,String nombre,String correo,String evento){
        return empleados.stream()
                .filter(EmpleadoBusquedaUtil.busarPorTodo(id,nombre,correo,evento))
                .collect(Collectors.toUnmodifiableList());
    }

}
