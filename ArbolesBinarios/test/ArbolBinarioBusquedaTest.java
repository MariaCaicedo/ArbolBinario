
import arbolesbinarios.ArbolBinarioBusqueda;
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
public class ArbolBinarioBusquedaTest {
    @Test
    public void contarCantidadDeNodos1(){
        //arrage
       ArbolBinarioBusqueda arbolBinario = new ArbolBinarioBusqueda();
       arbolBinario.insertar('1');
       
       //action
       int cantNodos=arbolBinario.ContarCantidadDeNodos(arbolBinario.retornarRaiz());
       
       //asert
       Assert.assertEquals(1, cantNodos);
    }
    
    @Test
    public void contarCantidadDeNodos0(){
      //arrage
       ArbolBinarioBusqueda arbolBinario = new ArbolBinarioBusqueda();
       
       //action
       int cantNodos=arbolBinario.ContarCantidadDeNodos(arbolBinario.retornarRaiz());
       
       //asert
       Assert.assertEquals(0, cantNodos);
}
    @Test
    public void contarCantidadDeNodos5(){
      //arrage
       ArbolBinarioBusqueda arbolBinario = new ArbolBinarioBusqueda();
       arbolBinario.insertar('1');
       arbolBinario.insertar('2');
       arbolBinario.insertar('3');
       arbolBinario.insertar('4');
       arbolBinario.insertar('5');
       
       //action
       int cantNodos=arbolBinario.ContarCantidadDeNodos(arbolBinario.retornarRaiz());
       
       //asert
       Assert.assertEquals(5, cantNodos);
}
    
}
