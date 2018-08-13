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
            mustraDatoEnInorden(raiz.getLigaIzquierda());
            System.out.println(raiz.getDato());
            mustraDatoEnInorden(raiz.getLigaDerecha());
        }
    }

    public void mustraDatoEnPosorden(Nodo raiz) {
        if (raiz != null) {
            mustraDatoEnPosorden(raiz.getLigaIzquierda());
            mustraDatoEnPosorden(raiz.getLigaDerecha());
            System.out.println(raiz);
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

    public void eliminar(Nodo nodo, int n) { // recibe el nodo raiz
        if (nodo == null) { // si el nodo es null no hace nada mas
            return;
        } else if (nodo.dato == n) { // se mira si el dato del nodo es el que se quiere borrar
            if (nodo == null && nodo == null) { // si el nodo es una hoja simplemente se elimina
                nodo = null;
                return;
            } else if (nodo != null && nodo == null) {// si el nodo solo tiene un hijo izquierdo el nodo se hace igual a ese hijo izquierdo
                nodo = nodo;
                return;
            } else if (nodo == null && nodo != null) {// si el nodo solo tiene un hijo derecho el nodo se hace igual a ese hijo derecho
                nodo = nodo;
                return;
            } else { // si el nodo tiene dos hijos, como el ultimo elemento de la raiz izquierda siempre es menor al primer de la raiz derecha
                Nodo a = nodo; // el nodo pasa a ser la raiz izq y se pone esa raiz derecha como hija der de ese mismo nodo
                nodo = nodo;
                Nodo aux = nodo;
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

        if (n < nodo.dato) { // recursion si el numero buscado es menor al que esta en el nodo actual se invoca a si mismo con el hijo izq
            eliminar(nodo, n);
        } else {
            eliminar(nodo, n);// en cambio si es mayor o igual se invoca a si mismo con el hijo der 
        }
    }
}
