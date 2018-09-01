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
            System.out.println(raiz.getEstudiante().toString());
            mustraDatoEnPreorden(raiz.getLigaIzquierda());
            mustraDatoEnPreorden(raiz.getLigaDerecha());
        }
    }

    public void mustraDatoEnInorden(Nodo raiz) {
        if (raiz != null) {
            mustraDatoEnInorden(raiz.getLigaDerecha());
            System.out.println(raiz.getEstudiante().toString());
            mustraDatoEnInorden(raiz.getLigaIzquierda());
        }
    }

    public void mustraDatoEnPosorden(Nodo raiz) {
        if (raiz != null) {
            mustraDatoEnPosorden(raiz.getLigaIzquierda());
            mustraDatoEnPosorden(raiz.getLigaDerecha());
            System.out.println(raiz.getEstudiante().toString());
        }
    }

    public Nodo insertar(Estudiante estudiante) {
        if (this.raiz == null) {
            return insertarEnRaiz(estudiante);
        }
        Nodo buscarSiExiste = this.buscarEstudianteConCedula(estudiante.getCedula());
        if (buscarSiExiste != null) {
            System.out.println("EL DATO YA EXISTE");
            return buscarSiExiste;
        }
        return this.buscarDondeEInsertarDato(this.raiz, estudiante);
    }

    private Nodo insertarEnRaiz(Estudiante estudiante) {
        return raiz = new Nodo(estudiante, null);
    }

    private Nodo buscarDondeEInsertarDato(Nodo raiz, Estudiante estudiante) {
        if (raiz.getEstudiante().getCedula().compareTo(estudiante.getCedula()) < 0) {
            if (raiz.getLigaDerecha() != null) {
                raiz = buscarDondeEInsertarDato(raiz.getLigaDerecha(), estudiante);
            } else {
                raiz.setLigaDerecha(new Nodo(estudiante, raiz));
            }
        } else if (raiz.getEstudiante().getCedula().compareTo(estudiante.getCedula()) > 0) {
            if (raiz.getLigaIzquierda() != null) {
                raiz = buscarDondeEInsertarDato(raiz.getLigaIzquierda(), estudiante);
            } else {
                raiz.setLigaIzquierda(new Nodo(estudiante, raiz));
            }
        }
        return raiz;
    }

    public boolean eliminar(String cedula) {
        if (raiz != null) {
            Nodo aEliminar = buscarEstudianteConCedula(cedula);
            if (aEliminar != null) {
                boolean sinHijoIzquierdo = aEliminar.getLigaIzquierda() == null;
                boolean sinHijoDerecho = aEliminar.getLigaDerecha() == null;
                if (sinHijoDerecho && sinHijoIzquierdo) {
                    return EliminarNodoSinHijos(aEliminar);
                }
                if (!sinHijoDerecho && sinHijoIzquierdo) {
                    return EliminarNodoConUnHijo(aEliminar);
                }
                if (sinHijoDerecho && !sinHijoIzquierdo) {
                    return EliminarNodoConUnHijo(aEliminar);
                }
                if (!sinHijoDerecho && !sinHijoIzquierdo) {
                    return EliminarNodoConHijos(aEliminar);
                }
            }
        }
        return false;
    }

    private boolean EliminarNodoSinHijos(Nodo aEliminar) {
        Nodo padre = aEliminar.getPadre();
        if (padre == null) {
            this.raiz = null;
        } else {
            if (padre.getLigaDerecha().getEstudiante().equals(aEliminar.getEstudiante())) {
                padre.setLigaDerecha(null);
            } else {
                padre.setLigaIzquierda(null);
            }
        }
        return true;
    }

    private boolean EliminarNodoConUnHijo(Nodo aEliminar) {
        Nodo padre = aEliminar.getPadre();
        if (padre == null) {
            if (this.raiz.getLigaDerecha() != null) {
                this.raiz = raiz.getLigaDerecha();
                raiz.getLigaDerecha().setPadre(null);
                return true;
            } else {
                this.raiz = raiz.getLigaIzquierda();
                raiz.getLigaIzquierda().setPadre(null);
                return true;
            }
        } else {
            if (padre.getLigaDerecha().equals(aEliminar)) {
                if (aEliminar.getLigaDerecha() == null) {
                    padre.setLigaDerecha(aEliminar.getLigaIzquierda());
                    padre.getLigaDerecha().setPadre(padre);
                    return true;
                } else {
                    padre.setLigaDerecha(aEliminar.getLigaDerecha());
                    padre.getLigaDerecha().setPadre(padre);
                    return true;
                }
            } else {
                if (aEliminar.getLigaDerecha() == null) {
                    padre.setLigaIzquierda(aEliminar.getLigaIzquierda());
                    padre.getLigaIzquierda().setPadre(padre);
                    return true;
                } else {
                    padre.setLigaIzquierda(aEliminar.getLigaDerecha());
                    padre.getLigaIzquierda().setPadre(padre);
                    return true;
                }
            }
        }
    }

    private boolean EliminarNodoConHijos(Nodo aEliminar) {
        Nodo padre = aEliminar.getPadre();
        if (padre == null) {
            Nodo hijoMasIzquierdo = obtenerNodoMasIzquierdo(this.raiz.getLigaDerecha());
            this.raiz.setEstudiante(hijoMasIzquierdo.getEstudiante());
            if (hijoMasIzquierdo.getLigaDerecha() != null) {
                hijoMasIzquierdo.setEstudiante(hijoMasIzquierdo.getLigaDerecha().getEstudiante());
                hijoMasIzquierdo.setLigaDerecha(null);
            } else if (!hijoMasIzquierdo.getPadre().equals(this.raiz)) {
                hijoMasIzquierdo.getPadre().setLigaIzquierda(null);
            }
            return true;
        } else {
            Nodo hijoMasIzquierdo = obtenerNodoMasIzquierdo(padre.getLigaDerecha());
            padre.setEstudiante(hijoMasIzquierdo.getEstudiante());
            if (hijoMasIzquierdo.getLigaDerecha() != null) {
                hijoMasIzquierdo.setEstudiante(hijoMasIzquierdo.getLigaDerecha().getEstudiante());
                hijoMasIzquierdo.setLigaDerecha(null);
            } else if (!hijoMasIzquierdo.getPadre().equals(padre)) {
                hijoMasIzquierdo.getPadre().setLigaIzquierda(null);
            }
            return true;
        }
    }

    private Nodo obtenerNodoMasIzquierdo(Nodo nodo) {
        return nodo.getLigaIzquierda() == null ? nodo : obtenerNodoMasIzquierdo(nodo);
    }

    public int ContarCantidadDeNodos(Nodo raiz) {
        int cantidadNodos = 0;
        if (raiz != null) {
            cantidadNodos++;
        }
        if (raiz != null && (raiz.getLigaDerecha() != null || raiz.getLigaIzquierda() != null)) {
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
            return (1);//+ raiz.getDato() + raiz.getDato());
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

    public Nodo buscarEstudianteConCedula(String cedula) {
        Nodo aux = this.raiz;
        while (aux != null) {
            if (aux.getEstudiante().getCedula().compareTo(cedula) < 0) {
                return aux;
            } else if (0 < aux.getEstudiante().getCedula().compareTo(cedula)) {
                aux = aux.getLigaIzquierda();
            } else {
                aux = aux.getLigaDerecha();
            }
        }
        return aux;
    }

}
