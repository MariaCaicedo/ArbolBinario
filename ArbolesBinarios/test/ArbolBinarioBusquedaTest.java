
import arbolesbinarios.ArbolBinarioBusqueda;
import arbolesbinarios.Nodo;
import org.junit.Assert;
import org.junit.Before;
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
    ArbolBinarioBusqueda arbolBinario;
    @Before
    public void inicializarTest(){
        arbolBinario = new ArbolBinarioBusqueda();
    }
    
    @Test
    public void contarCantidadDeNodos1(){
        //arrage
       arbolBinario.insertar('1');
       
       //action
       int cantNodos=arbolBinario.ContarCantidadDeNodos(arbolBinario.retornarRaiz());
       
       //asert
       Assert.assertEquals(1, cantNodos);
    }
    
    @Test
    public void contarCantidadDeNodos0(){       
       //action
       int cantNodos=arbolBinario.ContarCantidadDeNodos(arbolBinario.retornarRaiz());
       
       //asert
       Assert.assertEquals(0, cantNodos);
}
    @Test
    public void contarCantidadDeNodos5(){
      //arrage
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
    
     @Test
     public void debeInsertarUnDatoCorrectamenteAlInicioDeLaLista(){
         arbolBinario.insertar('8');
         
         Assert.assertEquals("El dato no se inserto correctamente",'8',arbolBinario.retornarRaiz().getDato());
     }
    
     @Test
     public void debeInsertarAlLadoDerechoDelArbol(){
         Nodo primerDato = arbolBinario.insertar('5');
         Nodo segundoDato = arbolBinario.insertar('9');
         
         Assert.assertNotNull("Se espera que la liga derecha de la raiz no sea null", arbolBinario.retornarRaiz().getLigaDerecha());
     }
     
     @Test
     public void debeInsertatAlLadoIzquierdoDelArbol(){
         
         Nodo primerDato = arbolBinario.insertar('5');
         Nodo segundoDato = arbolBinario.insertar('1');
         
         Assert.assertNotNull("Se espera que la liga derecha de la raiz no sea null", arbolBinario.retornarRaiz().getLigaIzquierda());
     }
     
     @Test
     public void debeInsertar3NivelesEnElOrden5423DebeQuedarIzquierdoIzquierdoDerecho(){
         Nodo primerNodo = arbolBinario.insertar('5');
         Nodo segundoNodo = arbolBinario.insertar('4');
         Nodo tercerNodo = arbolBinario.insertar('2');
         Nodo cuartoNodo = arbolBinario.insertar('3');
         Assert.assertEquals("liga derecha de la liga izquierda de liga izquierda de la raiz sea el cuarto nodo insertado", '3', 
                 arbolBinario.retornarRaiz().getLigaIzquierda().getLigaIzquierda().getLigaDerecha().getDato());
     }
     
     @Test
     public void debeInsertar3NivelesEnElOrden5687DebeQuedarDerechoDerechoIzquierdo(){
         Nodo primerNodo = arbolBinario.insertar('5');
         Nodo segundoNodo = arbolBinario.insertar('6');
         Nodo tercerNodo = arbolBinario.insertar('8');
         Nodo cuartoNodo = arbolBinario.insertar('7');
         Assert.assertEquals("liga izquierda de liga derecha de liga derecha de la raiz sea el cuarto nodo insertado", '7', 
                 arbolBinario.retornarRaiz().getLigaDerecha().getLigaDerecha().getLigaIzquierda().getDato());
         }
     
     @Test
     public void debeBuscarUnNodoQueEstaEnLaRaizDelArbol(){
         Nodo primerDato = arbolBinario.insertar('5');
         Nodo respuestaDeLaBusqueda = arbolBinario.buscarNodo('5');
         Assert.assertEquals("se esperaba la raiz del arbol", arbolBinario.retornarRaiz(), respuestaDeLaBusqueda);
     }
     
     @Test
     public void noDebeEncontrarElNodoEnElArbolVacio(){
         Nodo respuestaDeBusqueda = arbolBinario.buscarNodo('d');
         Assert.assertNull("Se esperaba un null, pero se recibio un nodo con dato",respuestaDeBusqueda);
     }
     
     @Test
     public void noDebeEncontrarNodoEnArbolConDatos(){
         arbolBinario.insertar('1');
         arbolBinario.insertar('2');
         arbolBinario.insertar('3');
         arbolBinario.insertar('4');
         
         Nodo respuestaDeBusqueda = arbolBinario.buscarNodo('9');
         
         Assert.assertNull("Se esperaba un null, pero se recibio un nodo con dato",respuestaDeBusqueda);         
     }
     
     @Test
     public void DebeEncontrarNodoEnArbolConDatos(){
         arbolBinario.insertar('1');
         arbolBinario.insertar('2');
         arbolBinario.insertar('3');
         arbolBinario.insertar('4');
         
         Nodo respuestaDeBusqueda = arbolBinario.buscarNodo('3');
         
         Assert.assertEquals("Se esperaba encontrar el nodo con el char 3",'3',respuestaDeBusqueda.getDato());         
     }
}
