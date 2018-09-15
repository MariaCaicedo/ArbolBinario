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

        Nodo buscarSiExiste = this.buscarEstudianteConCedula("" + estudiante.getCedula());
        if (buscarSiExiste != null) {
            System.out.println("EL ESTUDIANTE CON CEDULA " + estudiante.getCedula() + " YA EXISTE");
            return buscarSiExiste;
        }
        return this.buscarDondeEInsertarDato(this.raiz, estudiante);
    }

    private Nodo insertarEnRaiz(Estudiante estudiante) {
        return raiz = new Nodo(estudiante, null);
    }

    private Nodo buscarDondeEInsertarDato(Nodo raiz, Estudiante estudiante) {
        if (raiz.getEstudiante().getCedula() < estudiante.getCedula()) {
            if (raiz.getLigaDerecha() != null) {
                raiz = buscarDondeEInsertarDato(raiz.getLigaDerecha(), estudiante);
            } else {
                raiz.setLigaDerecha(new Nodo(estudiante, raiz));
            }
        } else if (raiz.getEstudiante().getCedula() > estudiante.getCedula()) {
            if (raiz.getLigaIzquierda() != null) {
                raiz = buscarDondeEInsertarDato(raiz.getLigaIzquierda(), estudiante);
            } else {
                raiz.setLigaIzquierda(new Nodo(estudiante, raiz));
            }
        }
        this.raiz = this.balancearArbol(this.raiz);
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
            this.raiz = this.balancearArbol(this.raiz);
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
            this.raiz = this.balancearArbol(this.raiz);
            return true;
        }
    }

    private Nodo obtenerNodoMasIzquierdo(Nodo nodo) {
        return nodo.getLigaIzquierda() == null ? nodo : obtenerNodoMasIzquierdo(nodo);
    }

    public int contarCantidadDeNodos(Nodo raiz) {
        int cantidadNodos = 0;
        if (raiz != null) {
            cantidadNodos++;
        }
        if (raiz != null && (raiz.getLigaDerecha() != null || raiz.getLigaIzquierda() != null)) {
            cantidadNodos += contarCantidadDeNodos(raiz.getLigaDerecha());
            cantidadNodos += contarCantidadDeNodos(raiz.getLigaIzquierda());
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
            return (contarCantidadDeNodos(raiz.getLigaDerecha()) + contarCantidadDeNodos(raiz.getLigaIzquierda()));
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
        return Altura(raiz, 1);
    }

    private int Altura(Nodo recorer, int nivel) {
        int altura = 0;
        if (recorer != null) {
            if (recorer.getLigaIzquierda() != null) {
                altura = Altura(recorer.getLigaIzquierda(), nivel + 1);
            }
            if (recorer.getLigaDerecha() != null) {
                altura = Altura(recorer.getLigaDerecha(), nivel + 1);
            }
            if (nivel > altura) {
                altura = nivel;
            }
        }
        return altura;
    }

    public Nodo buscarEstudianteConCedula(String cedula) {
        Nodo aux = this.raiz;
        while (aux != null) {
            if (aux.getEstudiante().getCedula() == Integer.parseInt(cedula)) {
                return aux;
            } else if (aux.getEstudiante().getCedula() < Integer.parseInt(cedula)) {
                aux = aux.getLigaIzquierda();
            } else {
                aux = aux.getLigaDerecha();
            }
        }
        return aux;
    }

    public int factorDeValance(Nodo raiz) {
        return altura(raiz.getLigaIzquierda()) - altura(raiz.getLigaDerecha());
    }

    public Nodo balancearArbol(Nodo raiz) {
        int factorDeBalance = this.factorDeValance(raiz);
        if (factorDeBalance == 2) {
            Nodo q = raiz.getLigaIzquierda();
            int factorDeBalanceDeQ = this.factorDeValance(q);
            if (factorDeBalanceDeQ == 1) {
                raiz = unaRotacionALaDerecha(raiz, q);
            }
            if (factorDeBalanceDeQ == -1) {
                raiz = dobleRotacionALaDerecha(raiz, q);
            }
            System.out.println("Se balanceo con factor de balance " + factorDeBalance + " y el de q fue " + factorDeBalanceDeQ);
        }
        if (factorDeBalance == -2) {
            Nodo q = raiz.getLigaDerecha();
            int factorDeBalanceDeQ = this.factorDeValance(q);
            if (factorDeBalanceDeQ == -1) {
                raiz = unaRotacionaLaIzquierda(raiz, q);
            }
            if (factorDeBalanceDeQ == 1) {
                raiz = dobleRotacionALaIzquierda(raiz, q);
            }
            System.out.println("Se balanceo con factor de balance " + factorDeBalance + " y el de q fue " + factorDeBalanceDeQ);
        }

        return raiz;
    }

    public Nodo unaRotacionALaDerecha(Nodo p, Nodo q) {
        p.setLigaIzquierda(q.getLigaDerecha());
        q.setLigaDerecha(p);
        return q;
    }

    public Nodo dobleRotacionALaDerecha(Nodo p, Nodo q) {
        Nodo r = q.getLigaDerecha();
        q.setLigaDerecha(q.getLigaIzquierda());
        r.setLigaIzquierda(q);
        p.setLigaIzquierda(r.getLigaDerecha());
        r.setLigaDerecha(p);
        return r;
    }

    public Nodo unaRotacionaLaIzquierda(Nodo p, Nodo q) {
        p.setLigaDerecha(q.getLigaIzquierda());
        q.setLigaIzquierda(p);
        return q;
    }

    public Nodo dobleRotacionALaIzquierda(Nodo p, Nodo q) {
        Nodo r = q.getLigaIzquierda();
        q.setLigaIzquierda(r.getLigaDerecha());
        r.setLigaDerecha(q);
        p.setLigaDerecha(r.getLigaIzquierda());
        r.setLigaIzquierda(p);
        return r;
    }

    public int altura(Nodo raiz) {
        int altura = 0;
        if (raiz != null) {
            if (this.raiz.getEstudiante().getCedula() == raiz.getEstudiante().getCedula()) {
                altura = 1;
            }
            if (raiz.getLigaDerecha() != null || raiz.getLigaIzquierda() != null) {
                altura++;
            }
            altura += this.altura(raiz.getLigaDerecha());
            altura += this.altura(raiz.getLigaIzquierda());
        }

        return altura;
    }

}
