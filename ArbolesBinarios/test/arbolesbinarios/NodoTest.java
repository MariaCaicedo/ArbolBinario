package arbolesbinarios;

import org.junit.Assert;
import org.junit.Test;

import arbolesbinarios.Estudiante;
import arbolesbinarios.Nodo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class NodoTest {

	Estudiante estudiante = new Estudiante("1040", "wilmar", "calle 1", 20);

	@org.junit.Test
	public void debeObtenerElDatoDelNodoAVerificarQueEsElCharJ() {
		// Arrange and action
		Nodo nodoPrueba = new Nodo(estudiante, null);

		// assert
		Assert.assertEquals(1040, nodoPrueba.getEstudiante().getCedula());
	}

	@Test
	public void debeObtenerLaLigaDerechaQueDebeSerNull() {
		Nodo nodoPrueba = new Nodo(estudiante, null);
		Assert.assertNull(nodoPrueba.getLigaDerecha());
	}

	@Test
	public void debeColocarElDatoDelNodoQueEsElCharA() {
		// arrange
		Nodo nodoPrueba = new Nodo(estudiante, null);

		// action
		Estudiante nuevo = new Estudiante("1", "nuevo", "nuevo", 20);
		nodoPrueba.setEstudiante(nuevo);

		// assert
		Assert.assertEquals("nuevo", nodoPrueba.getEstudiante().getNombre());
	}
}
