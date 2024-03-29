package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controller.service;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.mapping.dto.EmpleadoDto;

import java.util.List;

public interface IEmpleadoControllerService {
    List<EmpleadoDto> obtenerEmpleados();

    boolean agregarEmpleado(EmpleadoDto empleadoDto);

    boolean eliminarEmpleado(String id);

    boolean actualizarEmpleado(String id, EmpleadoDto empleadoDto);
}
