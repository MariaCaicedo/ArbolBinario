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
        String menu = "**MENU**" + "\n" + "0. Salir" + "\n" + "11. Mostrar" + "\n" + "22. Insertar" + "\n" + "33. Eliminar";
        char datoObtenido;
        while (true) {
            int opcionSelecionadaDelMenu = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "MENU", JOptionPane.DEFAULT_OPTION));
            switch (opcionSelecionadaDelMenu) {
                case 0:
                    return;
                case 11:
                    System.out.println("Estos son los datos del arbol: ");
                    arbolBinario.mustraDatoEnInorden(arbolBinario.retornarRaiz());
                    System.out.println("Ya estan todos los datos.");
                    break;
                case 22:
                    String datoAInsertar = JOptionPane.showInputDialog(null, "Debe ingresar un solo caracter", "Ingrese Dato", JOptionPane.DEFAULT_OPTION);
                    datoObtenido = datoAInsertar.charAt(0);
                    arbolBinario.insertar(datoObtenido);
                    System.out.println("Dato Insertado");
                    break;
                case 33:
                    String datoAEliminar = JOptionPane.showInputDialog(null, "Debe ingresar el caracter a eliminar", "Eliminar Caracter", JOptionPane.DEFAULT_OPTION);
                    datoObtenido = datoAEliminar.charAt(0);
                    arbolBinario.eliminar(arbolBinario.retornarRaiz(), datoObtenido);
                    System.out.println("Dato Eliminado");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida", "Intente de nuevo", JOptionPane.WARNING_MESSAGE);

            }
        }
    }

}
