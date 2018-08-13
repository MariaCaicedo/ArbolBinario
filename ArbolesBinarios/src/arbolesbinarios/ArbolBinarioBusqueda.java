/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

/**
 *
 * @author sala203
 */
public class ArbolBinarioBusqueda {

    private Nodo raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public void mustraDatoEnPreorden(Nodo raiz) {
        if (raiz != null) {
            System.out.println(raiz.getDato());
            mustraDatoEnPreorden(raiz.getLigaIzquierda());
            mustraDatoEnPreorden(raiz.getLigaDerecha());
        }
    }

    public void mustraDatoEnInorden(Nodo raiz) {
        if (raiz != null) {
            mustraDatoEnInorden(raiz.getLigaDerecha());
            System.out.println(raiz.getDato());
            mustraDatoEnInorden(raiz.getLigaIzquierda());
        }
    }

    public void insertar(char dato) {
        Nodo p = this.raiz;
        Nodo anterior = null;
        while (p != null) {
            if (p.getDato() == dato) {
                System.out.println("EL DATO YA EXISTE");
                return;
            } else if (p.getDato() < dato) {
                anterior = p;
                p = p.getLigaDerecha();
            } else if (p.getDato() > dato) {
                anterior = p;
                p = p.getLigaIzquierda();
            }
        }
        Nodo nuevoDato = new Nodo(dato);
        if (anterior.getLigaIzquierda() == null) {
            anterior.setLigaIzquierda(nuevoDato);
        } else {
            anterior.setLigaDerecha(nuevoDato);
        }
    }

    public void eliminar(Nodo nodo, int n) { // recibe el nodo raiz; recibe mas quue el nodo raiz, que es lo otro que recibe y por que? piensalo y corrige el dato que debe recibir.
        if (nodo == null) {
            return;
        } else if (nodo.dato == n) {
            if (nodo == null && nodo == null) { // si el nodo es una hoja simplemente se elimina; la condicion es redundante, pregunta lo mismo 2 veces, revisa amor.
                nodo = null;
                return;
            } else if (nodo != null && nodo == null) {// si el nodo solo tiene un hijo izquierdo el nodo se hace igual a ese hijo izquierdo; en nigun ligar pregunta por los hijos, revisa que metodos debes llamar de nodo para que el nodo te diga si tiene o no hijos.
                nodo = nodo;
                return;
            } else if (nodo == null && nodo != null) {// si el nodo solo tiene un hijo derecho el nodo se hace igual a ese hijo derecho; el mismo problema de lla condicion anterior.
                nodo = nodo;
                return;
            } else { // si el nodo tiene dos hijos, como el ultimo elemento de la raiz izquierda siempre es menor al primer de la raiz derecha, no logro entender esta perte del codigo amor.
                Nodo a = nodo; // el nodo pasa a ser la raiz izq y se pone esa raiz derecha como hija der de ese mismo nodo; coloca nombres descriptivos, ¿para que es a?.
                nodo = nodo; // por quue nodo = nodo?
                Nodo aux = nodo; // para que es el auxiliar, que vas hacer con el, cambiale el nombre a algo que diga que se va hacer.
                while (true) {
                    if (nodo == null) {
                        aux = a;
                    } else {
                        aux = a;
                        break;
                    }
                }
                return;
            }
        }
        if (n < nodo.dato) { // recursion si el numero buscado es menor al que esta en el nodo actual se invoca a si mismo con el hijo izq, creo que ya corregiste lo del numero arriba.
            eliminar(nodo, n);//creo que ya corregiste lo de llamar a la ligaizquierda o derecha segun el caso
        } else {
            eliminar(nodo, n);// en cambio si es mayor o igual se invoca a si mismo con el hijo der 
        }
    }
}
