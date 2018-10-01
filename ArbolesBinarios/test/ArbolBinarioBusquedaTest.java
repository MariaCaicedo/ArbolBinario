
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import arbolesbinarios.ArbolBinarioBusqueda;
import arbolesbinarios.Estudiante;
import arbolesbinarios.Nodo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
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
        // arrage
        arbolBinario.insertar(estudiante);

        // action
        int cantNodos = arbolBinario.contarCantidadDeNodos(arbolBinario.retornarRaiz());

        // asert
        Assert.assertEquals(1, cantNodos);
    }

    @Test
    public void contarCantidadDeNodos0() {
        // action
        int cantNodos = arbolBinario.contarCantidadDeNodos(arbolBinario.retornarRaiz());

        // asert
        Assert.assertEquals(0, cantNodos);
    }

    @Test
    public void contarCantidadDeNodos5() {
        // arrage
        ArbolBinarioBusqueda arbolBinarioContar = new ArbolBinarioBusqueda();
        Estudiante nuevo = new Estudiante("1", "juan", "calle", 20);
        arbolBinarioContar.insertar(nuevo);
        Estudiante nuevo1 = new Estudiante("2", "andre", "calle", 20);
        arbolBinarioContar.insertar(nuevo1);
        Estudiante nuevo2 = new Estudiante("3", "felipe", "calle", 20);
        arbolBinarioContar.insertar(nuevo2);
        Estudiante nuevo3 = new Estudiante("4", "juan", "calle", 20);
        arbolBinarioContar.insertar(nuevo3);
        Estudiante nuevo4 = new Estudiante("5", "calvito", "calle", 20);
        arbolBinarioContar.insertar(nuevo4);

        // action
        int cantNodos = arbolBinarioContar.contarCantidadDeNodos(arbolBinarioContar.retornarRaiz());

        // asert
        Assert.assertEquals(5, cantNodos);
    }

    @Test
    public void debeInsertarUnDatoCorrectamenteAlInicioDeLaLista() {
        Estudiante nuevo = new Estudiante("8", "juan", "carrera", 10);
        arbolBinario.insertar(nuevo);

        Assert.assertEquals("El dato no se inserto correctamente", 8,
                arbolBinario.retornarRaiz().getEstudiante().getCedula());
    }

    @Test
    public void debeInsertarAlLadoDerechoDelArbol() {
        estudiante = new Estudiante("10", "nombre", "direccion", 8);
        arbolBinario.insertar(estudiante.setCedula("10"));
        Estudiante nuevo = new Estudiante("20", "juan", "calle", 20);
        arbolBinario.insertar(nuevo);

        Assert.assertNotNull("Se espera que la liga derecha de la raiz no sea null",
                arbolBinario.retornarRaiz().getLigaDerecha());
    }

    @Test
    public void debeInsertatAlLadoIzquierdoDelArbol() {
        ArbolBinarioBusqueda arbolBinario2 = new ArbolBinarioBusqueda();
        Estudiante estudiante = new Estudiante("5", "nombre", "direccion", 8);
        arbolBinario2.insertar(estudiante);
        Estudiante nuevo = new Estudiante("1", "juan", "calle", 20);
        arbolBinario2.insertar(nuevo);

        Assert.assertNotNull("Se espera que la liga izquierda de la raiz no sea null",
                arbolBinario2.retornarRaiz().getLigaIzquierda());
    }

    @Test
    public void debeInsertar3Niveles() {
        Estudiante estudiante1 = new Estudiante("14", "juan", "calle", 20);
        arbolBinario.insertar(estudiante1);
        Assert.assertEquals("raiz 14 no insertado", 14, arbolBinario.retornarRaiz().getEstudiante().getCedula());

        Estudiante estudiante2 = new Estudiante("6", "juan", "calle", 20);
        arbolBinario.insertar(estudiante2);
        Assert.assertEquals("hijo izquierdo 6 mal insertado", 6, arbolBinario.retornarRaiz().getLigaIzquierda().getEstudiante().getCedula());

        Estudiante estudiante3 = new Estudiante("24", "juan", "calle", 20);
        arbolBinario.insertar(estudiante3);
        Assert.assertEquals("hijo derecho 24 mal insertado", 24, arbolBinario.retornarRaiz().getLigaDerecha().getEstudiante().getCedula());

        Estudiante estudiante4 = new Estudiante("15", "juan", "calle", 20);
        arbolBinario.insertar(estudiante4);
        Assert.assertEquals(
                "hijo izquierdo del hijo derecho la raiz mal insertado", 15,
                arbolBinario.retornarRaiz().getLigaDerecha().getLigaIzquierda().getEstudiante().getCedula());

        Estudiante estudiante6 = new Estudiante("16", "juan", "calle", 20);
        arbolBinario.insertar(estudiante6);
        Assert.assertEquals("nuevo hijo derecho mal insertado o mal rotado", 16,
                arbolBinario.retornarRaiz().getLigaDerecha().getEstudiante().getCedula());
    }

    @Test
    public void debeInsertar3NivelesEnElOrden616134() {
        estudiante = new Estudiante("6", "juan", "calle", 20);
        arbolBinario.insertar(estudiante);
        Assert.assertEquals("se espera que la raiz sea 6", 6, arbolBinario.retornarRaiz().getEstudiante().getCedula());

        estudiante = new Estudiante("16", "juan", "calle", 20);
        arbolBinario.insertar(estudiante);
        Assert.assertEquals("se espera que la liga derecha de la raiz sea 16", 16,
                arbolBinario.retornarRaiz().getLigaDerecha().getEstudiante().getCedula());

        estudiante = new Estudiante("13", "juan", "calle", 20);
        arbolBinario.insertar(estudiante);
        Assert.assertEquals("se espera la nueva raiz sea 13", 13,
                arbolBinario.retornarRaiz().getEstudiante().getCedula());

        estudiante = new Estudiante("4", "juan", "calle", 20);
        arbolBinario.insertar(estudiante);
        Assert.assertEquals("se espera que la liga mas izquierda de la raiz sea 4",
                4, arbolBinario.retornarRaiz().getLigaIzquierda().getLigaIzquierda().getEstudiante().getCedula());
    }

    @Test
    public void debeInsertarEnElOrden111614638232624() {
        ArbolBinarioBusqueda pruebaArbol = new ArbolBinarioBusqueda();
        Estudiante estudiante1 = new Estudiante("11", "juan", "calle", 20);
        pruebaArbol.insertar(estudiante1);
        Assert.assertEquals("se esperaba la raiz sea el nodo insertado con cedula", 11,
                pruebaArbol.retornarRaiz().getEstudiante().getCedula());

        Estudiante estudiante2 = new Estudiante("16", "juan", "calle", 20);
        pruebaArbol.insertar(estudiante2);
        Assert.assertEquals("se esperaba que la liga derecha de la raiz sea el nodo insertado con cedula", 16,
                pruebaArbol.retornarRaiz().getLigaDerecha().getEstudiante().getCedula());

        Estudiante estudiante3 = new Estudiante("14", "juan", "calle", 20);
        pruebaArbol.insertar(estudiante3);
        Assert.assertEquals("se esperaba la raiz sea el nodo insertado con cedula", 14,
                pruebaArbol.retornarRaiz().getEstudiante().getCedula());

        Estudiante estudiante4 = new Estudiante("6", "juan", "calle", 20);
        pruebaArbol.insertar(estudiante4);
        Assert.assertEquals("se esperaba que la liga derecha de la raiz sea el nodo insertado con cedula", 16,
                pruebaArbol.retornarRaiz().getLigaDerecha().getEstudiante().getCedula());

        Estudiante estudiante5 = new Estudiante("3", "juan", "calle", 20);
        pruebaArbol.insertar(estudiante5);
        Assert.assertEquals("se esperaba que la liga izquierda de la raiz sea el nodo insertado con cedula", 11,
                pruebaArbol.retornarRaiz().getLigaIzquierda().getEstudiante().getCedula());

        Estudiante estudiante6 = new Estudiante("8", "juan", "calle", 20);
        pruebaArbol.insertar(estudiante6);
        Assert.assertEquals("se esperaba que la liga izquierda de la raiz sea el nodo insertado con cedula", 6,
                pruebaArbol.retornarRaiz().getLigaIzquierda().getEstudiante().getCedula());

        Estudiante estudiante7 = new Estudiante("23", "juan", "calle", 20);
        pruebaArbol.insertar(estudiante7);
        Assert.assertEquals("se esperaba la raiz sea el nodo insertado con cedula", 11,
                pruebaArbol.retornarRaiz().getEstudiante().getCedula());

        Estudiante estudiante8 = new Estudiante("26", "juan", "calle", 20);
        pruebaArbol.insertar(estudiante8);
        Estudiante estudiante9 = new Estudiante("24", "juan", "calle", 20);
        pruebaArbol.insertar(estudiante9);

        Assert.assertEquals("se esperaba la raiz sea el nodo insertado con cedula", 11,
                pruebaArbol.retornarRaiz().getEstudiante().getCedula());
        Assert.assertEquals("se esperaba que la liga derecha de la raiz sea el nodo insertado con cedula", 16,
                pruebaArbol.retornarRaiz().getLigaDerecha().getEstudiante().getCedula());
        Assert.assertEquals("se esperaba que la liga izquierda de la raiz sea el nodo insertado con cedula", 6,
                pruebaArbol.retornarRaiz().getLigaIzquierda().getEstudiante().getCedula());
    }

    @Test
    public void debeBuscarUnNodoQueEstaEnLaRaizDelArbol() {
        Estudiante prueba = new Estudiante();
        arbolBinario.insertar(prueba.setCedula("5"));
        Nodo respuestaDeLaBusqueda = arbolBinario.buscarEstudianteConCedula(5);
        Assert.assertEquals("se esperaba la raiz del arbol", arbolBinario.retornarRaiz(), respuestaDeLaBusqueda);
    }

    @Test
    public void noDebeEncontrarElNodoEnElArbolVacio() {
        Nodo respuestaDeBusqueda = arbolBinario.buscarEstudianteConCedula(5);
        Assert.assertNull("Se esperaba un null, pero se recibio un nodo con dato", respuestaDeBusqueda);
    }

    @Test
    public void noDebeEncontrarNodoEnArbolConDatos() {
        Estudiante estudiante0 = new Estudiante();
        arbolBinario.insertar(estudiante0.setCedula("1"));
        Estudiante estudiante1 = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante1.setCedula("2"));
        Estudiante estudiante2 = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante2.setCedula("3"));
        Estudiante estudiante3 = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante3.setCedula("4"));

        Nodo respuestaDeBusqueda = arbolBinario.buscarEstudianteConCedula(5);

        Assert.assertNull("Se esperaba un null, pero se recibio un nodo con dato", respuestaDeBusqueda);
    }

    @Test
    public void debeEncontrarNodoEnArbolConDatosAlaDerecha() {
        arbolBinario.insertar(estudiante.setCedula("1"));
        estudiante = new Estudiante("2", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("2"));
        estudiante = new Estudiante("3", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("3"));

        Nodo respuestaDeBusqueda = arbolBinario.buscarEstudianteConCedula(3);

        Assert.assertNotNull(respuestaDeBusqueda);
        Assert.assertEquals("Se esperaba encontrar el Estudiante con cedula 3", 3,
                respuestaDeBusqueda.getEstudiante().getCedula());
    }

    @Test
    public void debeEncontrarNodoEnArbolConDatosALaIzquierda() {
        arbolBinario.insertar(estudiante.setCedula("3"));
        estudiante = new Estudiante("2", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("2"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("1"));

        Nodo respuestaDeBusqueda = arbolBinario.buscarEstudianteConCedula(3);

        Assert.assertNotNull(respuestaDeBusqueda);
        Assert.assertEquals("Se esperaba encontrar el Estudiante con cedula 3", 3,
                respuestaDeBusqueda.getEstudiante().getCedula());
    }

    @Test
    public void debeEncontrarNodoEnArbolConDatos() {
        arbolBinario.insertar(estudiante.setCedula("1"));
        estudiante = new Estudiante("8", "juan", "calle", 20);
        arbolBinario.insertar(estudiante);
        estudiante = new Estudiante("5", "juan", "calle", 20);
        arbolBinario.insertar(estudiante);
        estudiante = new Estudiante("2", "juan", "calle", 20);
        arbolBinario.insertar(estudiante);
        estudiante = new Estudiante("3", "juan", "calle", 20);
        arbolBinario.insertar(estudiante);

        Nodo respuestaDeBusqueda = arbolBinario.buscarEstudianteConCedula(3);

        Assert.assertNotNull(respuestaDeBusqueda);
        Assert.assertEquals("Se esperaba encontrar el Estudiante con cedula 3", 3,
                respuestaDeBusqueda.getEstudiante().getCedula());
    }

    @Test
    public void noDebeEliminarNingunDatoDelArbolVacio() {
        boolean respuesta = arbolBinario.eliminar(5);
        Assert.assertFalse("Se esperaba que no eliminara nada", respuesta);
    }

    @Test
    public void debeEliminarElUnicoDatoDelArbol() {
        arbolBinario.insertar(estudiante.setCedula("5"));
        boolean respusta = arbolBinario.eliminar(5);
        Assert.assertTrue("Se esperaba que eliminara el dato", respusta);
        Assert.assertNull(arbolBinario.retornarRaiz());
    }

    @Test
    public void noDebeEliminarUnDatoQueNoExisteEnElArbol() {
        arbolBinario.insertar(estudiante.setCedula("5"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("2"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("8"));
        boolean response = arbolBinario.eliminar(1);
        Assert.assertFalse("Se es´peraba que no eiminara el dato", response);
    }

    @Test
    public void debeEliminarElUnicoHijoDerecho() {
        arbolBinario.insertar(estudiante.setCedula("5"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("2"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("8"));
        arbolBinario.eliminar(8);
        Assert.assertNull("Se esperaba que el Nodo con el char 8 no exista", arbolBinario.buscarEstudianteConCedula(8));
    }

    @Test
    public void debeEliminarElUnicoHijoIzquierdo() {
        arbolBinario.insertar(estudiante.setCedula("5"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("2"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("8"));
        arbolBinario.eliminar(2);
        Assert.assertNull("Se espera que el Nodo con el caracter 2 no exista",
                arbolBinario.buscarEstudianteConCedula(2));
    }

    @Test
    public void debeEliminarLaRaizCuandoTieneHijos() {
        arbolBinario.insertar(estudiante.setCedula("5"));
        Estudiante nuevo = new Estudiante("2", "juan", "calle", 20);
        arbolBinario.insertar(nuevo);
        Estudiante nuevoEstudiante = new Estudiante("8", "juan", "calle", 20);
        arbolBinario.insertar(nuevoEstudiante);
        arbolBinario.eliminar(5);
        Assert.assertNull("Se espera que el Nodo con el caracter 5 no exista",
                arbolBinario.buscarEstudianteConCedula(5));
        Assert.assertNotNull("Se espera que el Nodo con el caracter 2 exista",
                arbolBinario.buscarEstudianteConCedula(2));
        Assert.assertNotNull("Se espera que el Nodo con el caracter 8 exista",
                arbolBinario.buscarEstudianteConCedula(8));
    }

    @Test
    public void debeEliminarElHijoIzquierdoDeLaRaiz() {
        arbolBinario.insertar(estudiante.setCedula("5"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("2"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante);
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("3"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("6"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("8"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("7"));
        estudiante = new Estudiante("1", "juan", "calle", 20);
        arbolBinario.insertar(estudiante.setCedula("19"));

        boolean response = arbolBinario.eliminar(6);

        Assert.assertTrue("se esperaba que el nodo fuera eliminado", response);
        Assert.assertFalse("Se esperaba que el Estudiante con cedula '6' no exista",
                arbolBinario.buscarEstudianteConCedula(6) != null);
        Assert.assertTrue("Se esperaba que el Estudiante con cedula '19' exista",
                arbolBinario.buscarEstudianteConCedula(19) != null);
    }

    @Test
    public void altura0() {
        int altura = arbolBinario.altura(arbolBinario.retornarRaiz());
        Assert.assertEquals("se esperaba que la altura sea 0", 0, altura);
    }

    @Test
    public void altura1() {
        arbolBinario.insertar(estudiante);

        int altura1 = arbolBinario.altura(arbolBinario.retornarRaiz());

        Assert.assertEquals("se esperaba que la altura fuese 1", 1, altura1);
    }

    @Test
    public void testaltura1() {
        arbolBinario.insertar(estudiante);

        int altura1 = arbolBinario.altura(arbolBinario.retornarRaiz());

        Assert.assertEquals("se esperaba que la altura fuese 1", 1, altura1);
    }

    @Test
    public void altura3test() {
        arbolBinario.insertar(estudiante.setCedula("6"));
        Estudiante nuevo = new Estudiante("1", "", "", 12);
        arbolBinario.insertar(nuevo);
        Estudiante nuevo1 = new Estudiante("5", "", "", 42);
        arbolBinario.insertar(nuevo1);
        estudiante = new Estudiante("2", "jaun", "calle", 18);
        arbolBinario.insertar(estudiante);

        int altura3 = arbolBinario.altura(arbolBinario.retornarRaiz());

        Assert.assertEquals("se esperaba que la altura fuese 3", 3, altura3);
    }

    @Test
    public void calecule0() {
        arbolBinario.insertar(estudiante);

        int valance = arbolBinario.factorDeValance(arbolBinario.retornarRaiz());

        Assert.assertEquals("se esperaba que el factor de valance sea 0", 0, valance);
    }

    @Test
    public void calculeMas1() {
        arbolBinario.insertar(estudiante.setCedula("80"));
        Estudiante nuevo = new Estudiante("70", "", "", 25);
        arbolBinario.insertar(nuevo);
        Estudiante nuevo1 = new Estudiante("90", "", "", 25);
        arbolBinario.insertar(nuevo1);
        Estudiante nuevo2 = new Estudiante("60", "", "", 20);
        arbolBinario.insertar(nuevo2);

        int valance = arbolBinario.factorDeValance(arbolBinario.retornarRaiz());

        Assert.assertEquals("se esperaba que el factor de valance sea mas1", +1, valance);
    }

    @Test
    public void calculaMenos1() {
        arbolBinario.insertar(estudiante.setCedula("80"));
        Estudiante nuevo = new Estudiante("95", "", "", 25);
        arbolBinario.insertar(nuevo);
        Estudiante nuevo1 = new Estudiante("81", "", "", 25);
        arbolBinario.insertar(nuevo1);
        Estudiante nuevo3 = new Estudiante("61", "", "", 25);
        arbolBinario.insertar(nuevo3);

        int valance = arbolBinario.factorDeValance(arbolBinario.retornarRaiz());

        Assert.assertEquals("se esperaba que el factor de valance sea -1", -1, valance);
    }
}
