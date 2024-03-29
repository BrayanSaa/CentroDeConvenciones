package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.mapping.mappers;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model.Empleado;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface CentroMapper {
    CentroMapper INSTANCE = Mappers.getMapper(CentroMapper.class);

    @Named("empleadoToEmpleadoDto")
    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);

    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EmpleadoDto> getEmpleadosDto(List<Empleado> listaEmpleados);

    @Mapping(target = "nombreCliente", source = "empleado.nombre")
    @IterableMapping(qualifiedByName = "cunetaToCuentaDto")
    EmpleadoDto clienteToClienteDto(Empleado empleado);
}
