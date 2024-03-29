package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controller;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controller.service.IModelFactoryService;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.exceptions.*;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.mapping.mappers.CentroMapper;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model.*;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.utils.CentroUtils;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService {

    Centro centro;
    CentroMapper mapper = CentroMapper.INSTANCE;

    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        cargarDatosBase();
    }

    private void cargarDatosBase() {
        centro = CentroUtils.inicializarDatos();
    }

    public Centro getBanco() {
        return centro;
    }

    public void setBanco(Centro centro) {
        this.centro = centro;
    }

    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        return  mapper.getEmpleadosDto(centro.getListaEmpleados());
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleadoDto) {
        try{
            if(!centro.verificarEmpleadoExistente(empleadoDto.id())) {
                Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
                getBanco().agregarEmpleado(empleado);
            }
            return true;
        }catch (EmpleadoException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String id) {
        boolean flagExiste = false;
        try {
            flagExiste = getBanco().eliminarEmpleado(id);
        } catch (EmpleadoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEmpleado(String id, EmpleadoDto empleadoDto) {
        try {
            Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
            getBanco().actualizarEmpleado(id, empleado);
            return true;
        } catch (EmpleadoException e) {
            e.printStackTrace();
            return false;
        }
    }
}
