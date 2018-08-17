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

   public void eliminar(char dato){
            Nodo aux = null, aux1 = null, otro = null;            
            if (dato < raiz.dato){
                eliminar(raiz.getDato());
            }
            else{
               if (dato > raiz.dato){
                    eliminar(raiz.getDato());
                }
                else{
                    otro = raiz;
                   if (otro != null){
                        if ((otro.getLigaDerecha()== null) && (otro.getLigaIzquierda() == null)){
                            otro = null;
                        }
                        else{
                            if (otro.getLigaDerecha() == null){
                                raiz = otro.getLigaIzquierda();
                            }
                            else if (otro.getLigaIzquierda()== null){
                                    raiz= otro.getLigaDerecha(); 
                                }
                                else{
                                    aux = otro.getLigaIzquierda();
                                    aux1 = aux;
                                    while (aux.getLigaDerecha() != null){
                                        aux1 = aux;
                                        aux = aux.getLigaDerecha();
                                    }
                                    otro.dato = aux.dato;
                                    otro = aux;
                                    aux = null;
                                }
                        }
                    }
                    else
                        System.out.println("DATO NO ENCONTRADO");
                }
            }
        }
    
    public void buscarNodo(int dato){
        Nodo aux=raiz;
        while(aux.dato!=dato){
            if(dato<aux.dato){
                aux=aux.getLigaIzquierda();
            }else{
                aux=aux.getLigaDerecha();
            }
            if(aux==null){
                return;
            }
        }        
    }
    
    public int Contar(Nodo raiz){
        if(raiz==null)
         return 0;
            if(raiz.getLigaDerecha()==null && raiz.getLigaIzquierda()==null)
            return 1;
                else
         return (Contar(raiz.getLigaDerecha())+Contar(raiz.getLigaIzquierda()));
    }
    
    public int cantidad(){
        if (raiz==null) {
            return 0;
        }
        else {
            return ( 1+ raiz.getDato() + raiz.getDato());
        }
    }
    
    public int altura() {
        if (raiz==null) {
            return 0;
        }
        else {
            return (1 + Math.max((raiz.dato, raiz.dato());
        }
    }
 
}
   
