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

    public void mustraDatoEnPosorden(Nodo raiz){
         if (raiz != null) {
            mustraDatoEnPosorden(raiz.getLigaIzquierda());
            mustraDatoEnPosorden(raiz.getLigaDerecha());
            System.out.println(raiz.getDato());             
         }
    }
    
    public Nodo insertar(char dato) {
        if (this.raiz == null) {
            return insertarEnRaiz(dato);
        }
        else if (this.buscarNodo(dato).getDato() == dato) {
            System.out.println("EL DATO YA EXISTE");
            return this.buscarNodo(dato);
        }
        else{
            Nodo nodoParaRecorrerElArbol = this.raiz;
            Nodo anterior = null;
            while (nodoParaRecorrerElArbol != null) {
                if (nodoParaRecorrerElArbol.getDato() < dato) {
                    anterior = nodoParaRecorrerElArbol;
                    nodoParaRecorrerElArbol = nodoParaRecorrerElArbol.getLigaDerecha();
                } else {
                    anterior = nodoParaRecorrerElArbol;
                    nodoParaRecorrerElArbol = nodoParaRecorrerElArbol.getLigaIzquierda();
                }
            }
            Nodo nuevoDato = new Nodo(dato);
            if(anterior == null){
                anterior = nodoParaRecorrerElArbol;
            }
            else if (anterior.getLigaIzquierda() == null) {
                anterior.setLigaIzquierda(nuevoDato);
            } else {
                anterior.setLigaDerecha(nuevoDato);
            }
            return anterior;
        }
   }
    
    private Nodo insertarEnRaiz(char dato){
        return raiz = new Nodo(dato);
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

    public Nodo buscarNodo(char dato) {
        Nodo aux = raiz;
        while (aux!=null) {
            if(aux.dato == dato){
                return aux;
            }
            else if (dato < aux.dato) {
                aux = aux.getLigaIzquierda();
            } else {
                aux = aux.getLigaDerecha();
            }
        }
        return aux;
    }

    public int ContarCantidadDeNodos(Nodo raiz) {
        int cantidadNodos = 0;
        if (raiz != null) {
            cantidadNodos++;
        }
        if (raiz !=null && (raiz.getLigaDerecha() != null || raiz.getLigaIzquierda() != null)) {
            cantidadNodos += ContarCantidadDeNodos(raiz.getLigaDerecha());
            cantidadNodos += ContarCantidadDeNodos(raiz.getLigaIzquierda());   
        }
        return cantidadNodos;
    }
    
    public int ContarCantidadDeHojas(Nodo raiz) {
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
        Altura(raiz, 1);
        return altura;
    }

    private void Altura(Nodo recorer, int nivel) {
        if (recorer != null) {
            Altura(recorer.getLigaIzquierda(), nivel + 1);
            int altura = 0;
            if (nivel > altura) {
                altura = nivel;
            }
            Altura(recorer.getLigaDerecha(), nivel + 1);
        }
    }
       
}
