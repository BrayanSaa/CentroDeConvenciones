package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model;

import java.util.ArrayList;

public class Empleado extends Persona{
    private Double salario;
    private String id;
    private String email;
    private String eventosAsignados;
    ArrayList<Evento> listaClientesAsociados = new ArrayList<Evento>();


    public Empleado() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getSalario() {
        return salario;
    }


    public void setSalario(Double salario) {
        this.salario = salario;
    }


    public ArrayList<Evento> getListaClientesAsociados() {
        return listaClientesAsociados;
    }


    public void setListaClientesAsociados(ArrayList<Evento> listClientesAsociados) {
        this.listaClientesAsociados = listClientesAsociados;
    }

}
