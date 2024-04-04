package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.utils;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model.Empleado;

import java.util.function.Predicate;

public class EmpleadoBusquedaUtil {
    public static Predicate<Empleado> buscarPorNumeroID(String id) {
        return empleado -> empleado.getID().equals(id);
    }

    public static Predicate<Empleado> buscarPorNombre(String nombre) {
        return empleado -> empleado.getNombre().equals(nombre);
    }

    public static Predicate<Empleado> buscarPorCorreo(String correo) {
        return empleado -> empleado.getCorreo().equals(correo);
    }

    public static Predicate<Empleado> buscarPorTodo(String id, String nombre, String correo) {
        Predicate<Empleado> predicado = estudiante -> true;
        if (id != null && !id.isEmpty()) {
            predicado = predicado.and(buscarPorNumeroID(id));
        }
        if (nombre != null && !nombre.isEmpty()) {
            predicado = predicado.and(buscarPorNombre(nombre));
        }
        if (correo != null && !correo.isEmpty()) {
            predicado = predicado.and(buscarPorCorreo((correo)));
        }
        return predicado;
    }
}
