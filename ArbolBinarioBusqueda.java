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

    public void eliminar(Nodo nodo, int dato) { 
        if (nodo == null) { 
            return;
        } else if (nodo.dato == dato) { 
            if (nodo == null && nodo == null) { 
                nodo = null;
                return;
            } else if (nodo != null && nodo == null) {
                nodo = nodo;
                return;
            } else if (nodo == null && nodo != null) {
                nodo = nodo;
                return;
            } else { 
                Nodo a = nodo; 
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

        if (dato < nodo.dato) { 
            eliminar(nodo, dato);
        } else {
            eliminar(nodo, dato);
        }
    }
}
