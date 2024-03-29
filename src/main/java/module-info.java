module co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.mapstruct;

    opens co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones to javafx.fxml;
    exports co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones;
    exports co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.viewController;
    opens co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.viewController to javafx.fxml;
    exports co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controller;
    exports co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.mapping.dto;
    exports co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.mapping.mappers;
    exports co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model;
    opens co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controller to javafx.fxml;
}