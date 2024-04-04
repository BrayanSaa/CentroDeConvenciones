package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.exceptions.ValorRequeridoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Empleado {
    private final String id;
    private final String nombre;
    private final String correo;
    private final List<String> eventos;

    public Empleado(String id, String nombre,String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        eventos = new ArrayList<>();
    }

    public static Empleado of(String id, String nombre,String correo)
            throws ValorRequeridoException {
        if (Objects.requireNonNull(id, "El ID es requerido").isEmpty()) {
            throw new ValorRequeridoException("numero ID");
        }
        if (Objects.requireNonNull(nombre, "El Nombre es requerido").isEmpty()) {
            throw new ValorRequeridoException("nombre");
        }
        Objects.requireNonNull(correo,"El genero es requerido");

        return new Empleado(id,nombre,correo);
    }


    public String getEventosString(){
        return eventos.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    public String getID() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public List<String> getEventos() {
        return eventos;
    }
}
