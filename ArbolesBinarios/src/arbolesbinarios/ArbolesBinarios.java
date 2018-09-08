package arbolesbinarios;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author sala203
 */
public class ArbolesBinarios {

    public static void main(String[] args) {
        ArbolBinarioBusqueda arbolBinario = new ArbolBinarioBusqueda();
        String menu = "**MENU**"
                + "\n" + "0. Salir"
                + "\n" + "11. Mostrar"
                + "\n" + "22. Insertar"
                + "\n" + "33. Eliminar"
                + "\n" + "44. Altura"
                + "\n" + "55. Buscar estudiante por Cedula";
        String datoObtenido;
        do {
            int opcionSelecionadaDelMenu = obtenerNumeroPorPantallaConMensaje(menu, "MENÚ");
            switch (opcionSelecionadaDelMenu) {
                case 0:
                    return;
                case 11:
                    if (arbolBinario.retornarRaiz() != null) {
                        int opcionMuestre = obtenerNumeroPorPantallaConMensaje("1. InOrden" + "\n" + "4. PosOrden" + "\n" + "7. PreOrden", "Ingrese Opción");
                        System.out.println("Estos son los datos del arbol: ");
                        switch (opcionMuestre) {
                            case 1:
                                arbolBinario.mustraDatoEnInorden(arbolBinario.retornarRaiz());
                                break;
                            case 4:
                                arbolBinario.mustraDatoEnPosorden(arbolBinario.retornarRaiz());
                                break;
                            case 7:
                                arbolBinario.mustraDatoEnPreorden(arbolBinario.retornarRaiz());
                                break;
                            default:
                                System.out.println("La Opcion " + opcionMuestre + " no estaba definida, por eso no se ven los estudiantes");
                        }
                        System.out.println("Ya estan todos los datos.");
                    } else {
                        System.out.println("Actualmente el arbol no contiene registros de estudiantes");
                    }
                    break;
                case 22:
                    String cedula = JOptionPane.showInputDialog(null, "Cedula", "Ingrese Dato", JOptionPane.DEFAULT_OPTION);
                    String nombre = JOptionPane.showInputDialog(null, "Nombre", "Ingrese Dato", JOptionPane.DEFAULT_OPTION);
                    String direcion = JOptionPane.showInputDialog(null, "Dirección", "Ingrese Dato", JOptionPane.DEFAULT_OPTION);
                    int edad = obtenerNumeroPorPantallaConMensaje("Edad", "Ingrese Dato");
                    Estudiante estudiante = new Estudiante(cedula, nombre, direcion, edad);
                    arbolBinario.insertar(estudiante);
                    System.out.println("Dato Insertado");
                    break;
                case 33:
                    String datoAEliminar = JOptionPane.showInputDialog(null, "Debe ingresar la cedula del estudiante a eliminar", "Eliminar estudiante", JOptionPane.DEFAULT_OPTION);
                    datoObtenido = datoAEliminar;
                    arbolBinario.eliminar(datoObtenido);
                    System.out.println("Dato Eliminado");
                    break;
                case 44:
                    System.out.println("La Altura del arbol es: " + arbolBinario.Altura());
                    break;
                case 55:
                    String buscar = JOptionPane.showInputDialog(null, "Ingrese la Cedula del Estudiante", "Buscar Estudiante", JOptionPane.DEFAULT_OPTION);
                    Nodo respuesta = arbolBinario.buscarEstudianteConCedula(buscar);
                    if (respuesta == null) {
                        System.out.println("Estudiante no Existe");
                    } else {
                        System.out.println(respuesta.getEstudiante().toString());
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida", "Intente de nuevo", JOptionPane.WARNING_MESSAGE);

            }
        } while (true);
    }

    static public int obtenerNumeroPorPantallaConMensaje(String mensaje, String titulo) {
        do {
            try {
                String texto = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION);
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Solo Numeros", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
    }
}
