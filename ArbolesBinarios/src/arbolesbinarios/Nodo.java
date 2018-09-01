package arbolesbinarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sala203
 */
public class Nodo {

    private Estudiante estudiante;
    private Nodo ligaDerecha;
    private Nodo ligaIzquierda;
    private Nodo padre;

    public Nodo(Estudiante estudiante, Nodo padre) {
        this.estudiante = estudiante;
        this.ligaDerecha = null;
        this.ligaIzquierda = null;
        this.padre = padre;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Nodo getLigaDerecha() {
        return ligaDerecha;
    }

    public Nodo getLigaIzquierda() {
        return ligaIzquierda;
    }

    public void setLigaDerecha(Nodo ligaDerecha) {
        this.ligaDerecha = ligaDerecha;
    }

    public void setLigaIzquierda(Nodo ligaIzquierda) {
        this.ligaIzquierda = ligaIzquierda;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

}
