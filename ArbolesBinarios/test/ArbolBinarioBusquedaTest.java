
import arbolesbinarios.ArbolBinarioBusqueda;
import arbolesbinarios.Estudiante;
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
    Estudiante estudiante;

    @Before
    public void inicializarTest() {
        arbolBinario = new ArbolBinarioBusqueda();
        estudiante = new Estudiante();
    }

    @Test
    public void contarCantidadDeNodos1() {
        //arrage
        arbolBinario.insertar(estudiante);

        //action
        int cantNodos = arbolBinario.ContarCantidadDeNodos(arbolBinario.retornarRaiz());

        //asert
        Assert.assertEquals(1, cantNodos);
    }

    @Test
    public void contarCantidadDeNodos0() {
        //action
        int cantNodos = arbolBinario.ContarCantidadDeNodos(arbolBinario.retornarRaiz());

        //asert
        Assert.assertEquals(0, cantNodos);
    }

    @Test
    public void contarCantidadDeNodos5() {
        //arrage
        Estudiante nuevo = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(nuevo);
        Estudiante nuevo1 = new Estudiante("2", "andre", "calle", 20);
        arbolBinario.insertar(nuevo);
        Estudiante nuevo2 = new Estudiante("3", "felipe", "calle", 20);
        arbolBinario.insertar(nuevo2);
        Estudiante nuevo3 = new Estudiante("4", "juan", "calle", 20);
        arbolBinario.insertar(nuevo3);
        Estudiante nuevo4 = new Estudiante("5", "calvito", "calle", 20);
        arbolBinario.insertar(nuevo4);

        //action
        int cantNodos = arbolBinario.ContarCantidadDeNodos(arbolBinario.retornarRaiz());

        //asert
        Assert.assertEquals(5, cantNodos);
    }

    @Test
    public void debeInsertarUnDatoCorrectamenteAlInicioDeLaLista() {
        Estudiante nuevo = new Estudiante("8", "juan", "carrera", 10);
        arbolBinario.insertar(nuevo);

        Assert.assertEquals("El dato no se inserto correctamente", "8", arbolBinario.retornarRaiz().getEstudiante().getCedula());
    }

    @Test
    public void debeInsertarAlLadoDerechoDelArbol() {
        Estudiante estudiante = new Estudiante("10", "nombre", "direccion", 8);
        Nodo primerDato = arbolBinario.insertar(estudiante.setCedula("10"));
        Estudiante nuevo = new Estudiante("20", "juan", "calle", 20);
        Nodo segundoDato = arbolBinario.insertar(nuevo);

        Assert.assertNotNull("Se espera que la liga derecha de la raiz no sea null", arbolBinario.retornarRaiz().getLigaDerecha());
    }

    @Test
    public void debeInsertatAlLadoIzquierdoDelArbol() {
        ArbolBinarioBusqueda arbolBinario2 = new ArbolBinarioBusqueda();
        Estudiante estudiante = new Estudiante("5", "nombre", "direccion", 8);
        Nodo primerDato = arbolBinario2.insertar(estudiante);
        Estudiante nuevo = new Estudiante("1", "juan", "calle", 20);
        Nodo segundoDato = arbolBinario2.insertar(nuevo);

        Assert.assertNotNull("Se espera que la liga izquierda de la raiz no sea null", arbolBinario2.retornarRaiz().getLigaIzquierda());
    }

    @Test
    public void debeInsertar3NivelesEnElOrden5423DebeQuedarIzquierdoIzquierdoDerecho() {
        Estudiante estudiante1 = new Estudiante("1", "juan", "calle", 20);
        Nodo primerNodo = arbolBinario.insertar(estudiante1.setCedula("5"));
        Estudiante estudiante2 = new Estudiante("2", "juan", "calle", 20);
        Nodo segundoNodo = arbolBinario.insertar(estudiante2.setCedula("4"));
        Estudiante estudiante3 = new Estudiante("3", "juan", "calle", 20);
        Nodo tercerNodo = arbolBinario.insertar(estudiante3.setCedula("2"));
        Estudiante estudiante4 = new Estudiante("4", "juan", "calle", 20);
        Nodo cuartoNodo = arbolBinario.insertar(estudiante4.setCedula("3"));
        arbolBinario.mustraDatoEnInorden(arbolBinario.retornarRaiz());
        Assert.assertEquals("liga derecha de la liga izquierda de liga izquierda de la raiz sea el cuarto nodo insertado", '3',
                arbolBinario.retornarRaiz().getLigaIzquierda().getLigaIzquierda().getLigaDerecha().getEstudiante().getCedula());
    }

    @Test
    public void debeInsertar3NivelesEnElOrden5687DebeQuedarDerechoDerechoIzquierdo() {
        Estudiante estudiante1 = new Estudiante("1", "juan", "calle", 20);
        Nodo primerNodo = arbolBinario.insertar(estudiante1.setCedula("5"));
        Estudiante estudiante2 = new Estudiante("1", "juan", "calle", 20);
        Nodo segundoNodo = arbolBinario.insertar(estudiante2.setCedula("6"));
        Estudiante estudiante3 = new Estudiante("1", "juan", "calle", 20);
        Nodo tercerNodo = arbolBinario.insertar(estudiante3.setCedula("8"));
        Estudiante estudiante4 = new Estudiante("1", "juan", "calle", 20);
        Nodo cuartoNodo = arbolBinario.insertar(estudiante4.setCedula("7"));

        arbolBinario.mustraDatoEnInorden(arbolBinario.retornarRaiz());
        Assert.assertEquals("liga izquierda de liga derecha de liga derecha de la raiz sea el cuarto nodo insertado", '7',
                arbolBinario.retornarRaiz().getLigaDerecha().getLigaDerecha().getLigaIzquierda().getEstudiante().getCedula());
    }

    @Test
    public void debeBuscarUnNodoQueEstaEnLaRaizDelArbol() {
        Estudiante estudiante = new Estudiante();
        Nodo primerDato = arbolBinario.insertar(estudiante.setCedula("5"));
        Nodo respuestaDeLaBusqueda = arbolBinario.buscarEstudianteConCedula("5");
        Assert.assertEquals("se esperaba la raiz del arbol", arbolBinario.retornarRaiz(), respuestaDeLaBusqueda);
    }

    @Test
    public void noDebeEncontrarElNodoEnElArbolVacio() {
        Nodo respuestaDeBusqueda = arbolBinario.buscarEstudianteConCedula("5");
        Assert.assertNull("Se esperaba un null, pero se recibio un nodo con dato", respuestaDeBusqueda);
    }

    @Test
    public void noDebeEncontrarNodoEnArbolConDatos() {
        Estudiante estudiante = new Estudiante();
        arbolBinario.insertar(estudiante.setCedula("1"));
        Estudiante estudiante1 = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante1.setCedula("2"));
        Estudiante estudiante2 = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante2.setCedula("3"));
        Estudiante estudiante3 = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante3.setCedula("4"));

        Nodo respuestaDeBusqueda = arbolBinario.buscarEstudianteConCedula("5");

        Assert.assertNull("Se esperaba un null, pero se recibio un nodo con dato", respuestaDeBusqueda);
    }

    @Test
    public void debeEncontrarNodoEnArbolConDatos() {
        arbolBinario.insertar(estudiante.setCedula("1"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("2"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("3"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("4"));

        Nodo respuestaDeBusqueda = arbolBinario.buscarEstudianteConCedula("3");

        Assert.assertEquals("Se esperaba encontrar el Estudiante con cedula 3", "3", respuestaDeBusqueda.getEstudiante().getCedula());
    }

    @Test
    public void noDebeEliminarNingunDatoDelArbolVacio() {
        boolean respuesta = arbolBinario.eliminar("5");
        Assert.assertFalse("Se esperaba que no eliminara nada", respuesta);
    }

    @Test
    public void debeEliminarElUnicoDatoDelArbol() {
        Nodo primero = arbolBinario.insertar(estudiante.setCedula("5"));
        boolean respusta = arbolBinario.eliminar("5");
        Assert.assertTrue("Se esperaba que eliminara el dato", respusta);
        Assert.assertNull(arbolBinario.retornarRaiz());
    }

    @Test
    public void noDebeEliminarUnDatoQueNoExisteEnElArbol() {
        Nodo primero = arbolBinario.insertar(estudiante.setCedula("5"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo segundo = arbolBinario.insertar(estudiante.setCedula("2"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo tercero = arbolBinario.insertar(estudiante.setCedula("8"));
        boolean response = arbolBinario.eliminar("1");
        Assert.assertFalse("Se es´peraba que no eiminara el dato", response);
    }

    @Test
    public void debeEliminarElUnicoHijoDerecho() {
        Nodo primero = arbolBinario.insertar(estudiante.setCedula("5"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo segundo = arbolBinario.insertar(estudiante.setCedula("2"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo tercero = arbolBinario.insertar(estudiante.setCedula("8"));
        arbolBinario.eliminar("8");
        Assert.assertNull("Se esperaba que el Nodo con el char 8 no exista", arbolBinario.buscarEstudianteConCedula("8"));
    }

    @Test
    public void debeEliminarElUnicoHijoIzquierdo() {
        Nodo primero = arbolBinario.insertar(estudiante.setCedula("5"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo segundo = arbolBinario.insertar(estudiante.setCedula("2"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo tercero = arbolBinario.insertar(estudiante.setCedula("8"));
        arbolBinario.eliminar("2");
        Assert.assertNull("Se espera que el Nodo con el caracter 2 no exista", arbolBinario.buscarEstudianteConCedula("2"));
    }

    @Test
    public void debeEliminarLaRaizCuandoTieneHijos() {
        Nodo primero = arbolBinario.insertar(estudiante.setCedula("5"));
        Estudiante nuevo = new Estudiante("2", "juan", "calle", 20);
        Nodo segundo = arbolBinario.insertar(nuevo);
        Estudiante nuevoEstudiante = new Estudiante("8", "juan", "calle", 20);
        Nodo tercero = arbolBinario.insertar(nuevoEstudiante);
        arbolBinario.eliminar("5");
        Assert.assertNull("Se espera que el Nodo con el caracter 5 no exista", arbolBinario.buscarEstudianteConCedula("5"));
        Assert.assertNotNull("Se espera que el Nodo con el caracter 2 exista", arbolBinario.buscarEstudianteConCedula("2"));
        Assert.assertNotNull("Se espera que el Nodo con el caracter 8 exista", arbolBinario.buscarEstudianteConCedula("8"));
    }

    @Test
    public void debeEliminarElHijoIzquierdoDeLaRaiz() {
        Nodo primero = arbolBinario.insertar(estudiante.setCedula("5"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo segundo = arbolBinario.insertar(estudiante.setCedula("2"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo tercero = arbolBinario.insertar(estudiante);
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo cuarto = arbolBinario.insertar(estudiante.setCedula("3"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo quinto = arbolBinario.insertar(estudiante.setCedula("6"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo sexto = arbolBinario.insertar(estudiante.setCedula("8"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo septimo = arbolBinario.insertar(estudiante.setCedula("7"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        Nodo octavo = arbolBinario.insertar(estudiante.setCedula("19"));

        boolean response = arbolBinario.eliminar("6");

        Assert.assertTrue("se esperaba que el nodo fuera eliminado", response);
        Assert.assertFalse("Se esperaba que el Estudiante con cedula '6' no exista", arbolBinario.buscarEstudianteConCedula("6") != null);
        Assert.assertTrue("Se esperaba que el Estudiante con cedula '19' exista", arbolBinario.buscarEstudianteConCedula("19") != null);
    }
}
