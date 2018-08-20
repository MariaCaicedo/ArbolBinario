package arbolesbinarios;

public class ArbolBinarioBusqueda {

    private Nodo raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public Nodo retornarRaiz() {
        return raiz;
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
        if (this.raiz == null) {
            raiz = new Nodo(dato);
            return;
        }
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

    public void eliminar(Nodo Raiz, char dato) {
        if (Raiz == null) {
            return;
        }
        Nodo ubicacionActualEnArbol = Raiz;
        if (dato == ubicacionActualEnArbol.getDato()) {
            raiz = ubicacionActualEnArbol.getLigaIzquierda();
            if (ubicacionActualEnArbol == this.raiz) {
                if (raiz != null) {
                    raiz.setLigaDerecha(ubicacionActualEnArbol.getLigaDerecha());
                }
            } else if (ubicacionActualEnArbol.getLigaDerecha() == null && ubicacionActualEnArbol.getLigaIzquierda() == null) {
                ubicacionActualEnArbol = null;
            }
        } else if (dato > ubicacionActualEnArbol.getDato()) {
            eliminar(ubicacionActualEnArbol.getLigaDerecha(), dato);
        } else if (dato < ubicacionActualEnArbol.getDato()) {
            eliminar(ubicacionActualEnArbol.getLigaIzquierda(), dato);
        }
    }

    public void buscarNodo(char dato) {
        Nodo aux = raiz;
        while (aux.dato != dato) {
            if (dato < aux.dato) {
                aux = aux.getLigaIzquierda();
            } else {
                aux = aux.getLigaDerecha();
            }
            if (aux == null) {
                return;
            }
        }
    }

    public int ContarCantidadDeNodos(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        if (raiz.getLigaDerecha() == null && raiz.getLigaIzquierda() == null) {
            return 1;
        } else {
            return (ContarCantidadDeNodos(raiz.getLigaDerecha()) + ContarCantidadDeNodos(raiz.getLigaIzquierda()));
        }
    }

    public int cantidad() {
        if (raiz == null) {
            return 0;
        } else {
            return (1 + raiz.getDato() + raiz.getDato());
        }
    }

    public int Altura() {
        int altura = 0;
        retornarAltura(raiz, 1);
        return altura;
    }

    private void retornarAltura(Nodo reco, int nivel) {
        if (reco != null) {
            retornarAltura(reco.getLigaIzquierda(), nivel + 1);
            int altura = 0;
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(reco.getLigaDerecha(), nivel + 1);
        }
    }

}
