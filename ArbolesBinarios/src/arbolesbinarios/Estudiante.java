package arbolesbinarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author sala203
 */
public class Estudiante {

	private int cedula;
	private String nombre;
	private String direccion;
	private int edad;

	public Estudiante(int cedula, String nombre, String direccion, int edad) {
		super();
		this.cedula = cedula;
		if (nombre != null)
			this.nombre = nombre;
		else
			this.nombre = "Sin Nombre";
		if (direccion != null)
			this.direccion = direccion;
		else
			this.direccion = "Sin Direccion";
		this.edad = edad;
	}

	public Estudiante() {
		super();
		this.cedula = 0;
		this.nombre = "";
		this.direccion = "";
		this.edad = 0;
	}

	public int getCedula() {
		return cedula;
	}

	public Estudiante setCedula(String cedula) {
		this.cedula = Integer.parseInt(cedula);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null)
			this.nombre = nombre;
		else
			this.nombre = "Sin Nombre";
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (direccion != null)
			this.direccion = direccion;
		else
			this.direccion = "Sin Direccion";
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
		return "Estudiante: [" + "Cedula: " + this.cedula + ", " + "Nombre: " + this.nombre + ", " + "Direccion: "
				+ this.direccion + ", " + "Edad: " + this.edad + "]";
	}
}
