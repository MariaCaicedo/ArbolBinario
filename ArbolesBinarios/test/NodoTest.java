
import arbolesbinarios.Nodo;
import org.junit.Assert;

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
    public void debeObtenerElDatoDelNodoVerificarQueEsElCharJ() {
        //Arrange and action
        Nodo nodoPrueba = new Nodo('J');
        
        //assert
        Assert.assertEquals('J', nodoPrueba.getDato());
    }

}
