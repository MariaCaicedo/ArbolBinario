
import arbolesbinarios.Estudiante;
import static org.junit.Assert.*;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sala203
 */
public class EstudianteTest {

    Estudiante estudiante = new Estudiante();

    @Test
    public void debeCrearEstudiateYObtenerNombre() {
        estudiante = new Estudiante("104", "juan", "carrera 52", 18);
        assertEquals("se esperaba que la cedula del estudiante sea 104", "104", estudiante.getCedula());
        assertEquals("se esperaba que el nombre del estudiante sea juan", "juan", estudiante.getNombre());
        assertEquals("se esperaba que la direccion del estudiante sea carrera 52", "carrera 52", estudiante.getDireccion());
        assertEquals("se espetaba que la edad del estudiante sea 18", 18, estudiante.getEdad());
    }
    
    @Test
    public void debeConvertirAStringCorrectamente() {
        estudiante = new Estudiante("10", "test", "carrera", 19);
        assertTrue(estudiante.toString().contains("Estudiante [Cedula: 10 Nombre: test Direcion: carrera edad: 19"));
    }
}
