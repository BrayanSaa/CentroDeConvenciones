module co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones to javafx.fxml;
    exports co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones;
    exports co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controllers;
    opens co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controllers to javafx.fxml;
}