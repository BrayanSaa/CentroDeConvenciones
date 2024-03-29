package co.edu.uniquindio.proyectofinal.centroconvenciones.centrodeconvenciones.model;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String direccion;
    private String email;
    private String fechaNacimiento;
    private String eventosAsignados;


    public Persona() {

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getFechaNacimiento() {
        return fechaNacimiento;
    }


    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getEventosAsignados() {
        return eventosAsignados;
    }


    public void setEventosAsignados(String fechaNacimiento) {
        this.eventosAsignados = eventosAsignados;
    }



}
