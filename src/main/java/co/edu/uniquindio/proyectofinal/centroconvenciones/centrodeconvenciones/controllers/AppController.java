package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controllers;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model.Administrador;

public enum AppController {
    INSTANCE;
    private final Administrador administrador;

    AppController(){administrador=new Administrador("root");
    }

    public Administrador getAdministrador() {
        return administrador;
    }
}
