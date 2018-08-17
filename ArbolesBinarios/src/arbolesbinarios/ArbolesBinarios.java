package arbolesbinarios;

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
        int opcionSelecionadaDelMenu = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch (opcionSelecionadaDelMenu) {
            case 0:
                return;
            case 11:
                System.out.println('probando');
            default:
                JOptionPane.showMessageDialog(this, 'Opcion no valida o no construida');
        }
    }

}
