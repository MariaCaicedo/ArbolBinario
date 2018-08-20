
import arbolesbinarios.Nodo;
import org.junit.Assert;
import org.junit.Test;


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

    @org.junit.Test
    public void debeObtenerElDatoDelNodoAVerificarQueEsElCharJ() {
        //Arrange and action
        Nodo nodoPrueba = new Nodo('J');

        //assert
        Assert.assertEquals('J', nodoPrueba.getDato());
    }
    @Test
    public void debeObtenerLaLigaDerechaQueDebeSerNull() {
        Nodo nodoPrueba = new Nodo('j');
        Assert.assertNull(nodoPrueba.getLigaDerecha());
    }
    @Test
    public void debeColocarElDatoDelNodoQueEsElCharA() {
        //arrange
        Nodo nodoPrueba = new Nodo('u');

        //action
        nodoPrueba.setDato('A');

        //assert
        Assert.assertEquals('A', nodoPrueba.getDato());
    }
}
