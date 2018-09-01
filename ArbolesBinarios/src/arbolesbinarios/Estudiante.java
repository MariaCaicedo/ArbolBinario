package arbolesbinarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sala203
 */
public class Estudiante {

    private String cedula;
    private String nombre;
    private String direccion;
    private int edad;

    public Estudiante(String cedula, String nombre, String direccion, int edad) {
        super();
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
    }

    public Estudiante() {
        super();
        this.cedula = "";
        this.nombre = "";
        this.direccion = "";
        this.edad = 0;
    }

    public String getCedula() {
        return cedula;
    }

    public Estudiante setCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Estudiante setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public Estudiante setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public Estudiante setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    @Override
    public String toString() {
        return "Estudiante: [" + "Cedula: " + this.cedula + " " + "Nombre: "
                + this.nombre + " " + "Direccion: " + this.direccion + " " + "Edad: " + this.edad;
    }
}
