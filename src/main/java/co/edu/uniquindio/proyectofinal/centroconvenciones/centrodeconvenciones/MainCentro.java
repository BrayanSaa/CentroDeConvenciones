package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones;

import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.controller.ModelFactoryController;
import co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.mapping.dto.EmpleadoDto;

import java.util.List;

public class MainCentro {
    public static void main(String[] args) {
        ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

        EmpleadoDto empleadoDto = new EmpleadoDto(
                "123",
                "jefferson",
                "jeffer2002@gmail.com",
                "Cumpleaños"
        );

        if(modelFactoryController.agregarEmpleado(empleadoDto)){
            System.out.println("No existe se agrgeo correctamente");
        }else{
            System.out.println("Ya existe");
        }

        List<EmpleadoDto> empleadoDtoList = modelFactoryController.obtenerEmpleados();
        empleadoDtoList.forEach(System.out::println);
    }
}
