package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controller;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controller.service.IEmpleadoControllerService;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.mapping.dto.EmpleadoDto;

import java.util.List;

public class EmpleadoController implements IEmpleadoControllerService {
    ModelFactoryController modelFactoryController;

    public EmpleadoController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<EmpleadoDto> obtenerEmpleados() {
        return modelFactoryController.obtenerEmpleados();
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleadoDto) {
        return modelFactoryController.agregarEmpleado(empleadoDto);
    }

    @Override
    public boolean eliminarEmpleado(String id) {
        return modelFactoryController.eliminarEmpleado(id);
    }

    @Override
    public boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto) {
        return modelFactoryController.actualizarEmpleado(cedulaActual, empleadoDto);
    }
}
