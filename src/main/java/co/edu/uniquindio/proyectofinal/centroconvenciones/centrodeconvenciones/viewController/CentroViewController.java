package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.viewController;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controller.CentroController;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controller.service.ICentroControllerService;
import javafx.fxml.FXML;

public class CentroViewController {

    ICentroControllerService centroControllerService;
@FXML
void initialize() {centroControllerService = new CentroController();
}
}
