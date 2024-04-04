package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.exceptions;

public class ValorRequeridoException extends Exception{
    public ValorRequeridoException(String nombre){
        super(String.format("El %s es requerido",nombre));
    }
}
