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
	private static ArbolBinarioBusqueda arbolBinary = new ArbolBinarioBusqueda();

	public static void main(String[] args) {

		String menu = "0. Salir" + "\n" + "11. Mostrar" + "\n" + "22. Insertar un Estudiante" + "\n" + "33. Eliminar"
				+ "\n" + "44. Altura" + "\n" + "55. Buscar estudiante por Cedula";
		do {
			if (arbolBinary.isEmpty()) {
				if (insert() == 0)
					break;
			} else {
				int optionSelectionOfMenu = obtenerNumeroPorPantallaConMensaje(menu, "MENÚ");
				switch (optionSelectionOfMenu) {
				case 0:
					return;
				case 11:
					mostrarEstudiantes();
					break;
				case 22:
					insert();
					break;
				case 33:
					eliminarEsudiante();
					break;
				case 44:
					int altura = arbolBinary.altura(arbolBinary.retornarRaiz());
					JOptionPane.showMessageDialog(null, "La Altura del arbol es: " + altura, "ALtura",
							JOptionPane.INFORMATION_MESSAGE);
					break;
				case 55:
					buscar();
					break;
				default:
					optionIncorrect(optionSelectionOfMenu, null);
				}
			}
		} while (true);
	}

	private static void eliminarEsudiante() {
		int dataEliminate = obtenerNumeroPorPantallaConMensaje("Debe ingresar la cedula del estudiante a eliminar",
				"Eliminar estudiante");
		if (dataEliminate != 0) {
			Boolean eliminado = arbolBinary.eliminar(dataEliminate);
			if (eliminado) {
				JOptionPane.showMessageDialog(null, "Estudiante con cedula " + dataEliminate + " eliminado con exito",
						"Dato Eliminado", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Estudiante con cedula " + dataEliminate + " no fue eliminado",
						"Dato No Eliminado", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private static void mostrarEstudiantes() {
		int opcionMuestre = obtenerNumeroPorPantallaConMensaje(
				"1. InOrden" + "\n" + "4. PosOrden" + "\n" + "7. PreOrden", "Ingrese Opción");
		System.out.println("Estos son los datos del arbol: ");
		switch (opcionMuestre) {
		case 1:
			arbolBinary.mustraDatoEnInorden(arbolBinary.retornarRaiz());
			break;
		case 4:
			arbolBinary.mustraDatoEnPosorden(arbolBinary.retornarRaiz());
			break;
		case 7:
			arbolBinary.mustraDatoEnPreorden(arbolBinary.retornarRaiz());
			break;
		default:
			optionIncorrect(opcionMuestre,
					"La Opcion " + opcionMuestre + " no estaba definida, por eso no se ven los estudiantes");
		}
		System.out.println("Ya estan todos los datos.");
	}

	private static void buscar() {
		int buscar = obtenerNumeroPorPantallaConMensaje("Ingrese la Cedula del Estudiante", "Buscar Estudiante");
		Nodo request = arbolBinary.buscarEstudianteConCedula(buscar);
		if (request == null) {
			JOptionPane.showMessageDialog(null, "Estudiante con cedula " + buscar + "no Existe",
					"Estudiante No Encontrado", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, request.getEstudiante().toString(), "Estudiante encontrado",
					JOptionPane.DEFAULT_OPTION);
		}
	}

	public static int obtenerNumeroPorPantallaConMensaje(String message, String title) {
		do {
			try {
				String text = JOptionPane.showInputDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
				if (text == null)
					return 0;
				else
					return Integer.parseInt(text);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Solo Numeros", JOptionPane.ERROR_MESSAGE);
			}
		} while (true);
	}

	static void optionIncorrect(int option, String message) {
		if ((message == null) || !message.isEmpty())
			message = "Opcion no es valida intente de nuevo";
		JOptionPane.showMessageDialog(null, message, "Opcion " + option, JOptionPane.ERROR_MESSAGE);
	}

	private static int insert() {
		int cedula = obtenerNumeroPorPantallaConMensaje("Cedula", "Ingrese cedula del estudiante");
		if (cedula > 0) {
			String nombre = JOptionPane.showInputDialog(null, "Nombre", "Ingrese nombre del estudiante",
					JOptionPane.DEFAULT_OPTION);
			String direcion = JOptionPane.showInputDialog(null, "Dirección", "Ingrese Dato",
					JOptionPane.DEFAULT_OPTION);
			int edad = obtenerNumeroPorPantallaConMensaje("Edad", "Ingrese Dato");
			Estudiante estudiante = new Estudiante(cedula, nombre, direcion, edad);
			Nodo insertado = arbolBinary.insertar(estudiante);
			JOptionPane.showMessageDialog(null, insertado.getEstudiante().toString() + " insertado con exito",
					"Estudiante Insertado", JOptionPane.INFORMATION_MESSAGE);
		}
		return cedula;
	}
}
