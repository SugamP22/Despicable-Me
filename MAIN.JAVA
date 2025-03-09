  
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);// para numero
	private static Scanner sl = new Scanner(System.in);// para letras
	private static Mision[] mision = new Mision[10];// array static
	private static Villano v1;// para poder usar sin incluir parametros

	public static void main(String[] args) {
		crearVillano();// aqui creamos villano
		int opcion = 0;
		do {
			menu();
			try {
				opcion = sc.nextInt();
				switchmain(opcion);
			} catch (InputMismatchException e) {
				sc.next();// limpiar buffer
			}
		} while (opcion != 5);
		System.out.println("\033[45mGracias por su Participacion\033[0m");
	}

	private static void switchmain(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("***** Crear Misiones *****");
			crearMisiones();// metodo doonde usamos un bucle para buscar un main
			break;
		case 2:
			System.out.println("***** Listar Misiones *****");
			listarMision();// usa un bucle para identificar y listar los misiones not null
			break;
		case 3:
			System.out.println("***** Listar Estedisticas Villano *****");
			listarVillano();

			break;
		case 4:
			System.out.println("***** Conseguir Victorias *****");
			conseguirVictorias();
			break;
		case 5:
			System.out.println("Saliendo....");
			break;
		default:
			System.out.println("***** Crear Misiones *****");
			break;
		}

	}

	private static void conseguirVictorias() {
		int sumaTotalTorpeza = 0;// Para guardar la torpeza del Torpeza
		int sumaTotalFuerza = 0;// para guardar la suma del Fuerza
		boolean flag = false;

		for (int i = 0; i < v1.getMinions().length; i++) {
			sumaTotalFuerza += v1.getMinions()[i].getFuerza();
			sumaTotalTorpeza += v1.getMinions()[i].getTorpeza();
		}

		int resultado = sumaTotalFuerza - sumaTotalTorpeza;
		System.out.println("Introduce Un nombre de mision:");
		String nombre = sl.nextLine();
		for (int i = 0; i < mision.length; i++) {
			if (mision[i] != null && mision[i].getNombre().equalsIgnoreCase(nombre)) {

				if (resultado > mision[i].getPuntuacionNecesaria()) {
					System.out.printf(
							"!! Felicidades Has conseguido una Victoria con %d fuerza y torpeza y %d puntuacionNecesario !!\n",
							resultado, mision[i].getPuntuacionNecesaria());
					mision[i] = null;
					for (int j = i; j < mision.length - 1; j++) {
						mision[j] = mision[j + 1];
					}
					mision[mision.length - 1] = null;
					v1.setNivelVictorias(v1.getNivelVictorias() + 1);
				} else {
					System.out.printf(
							"!! Buen Intento, Pero te falta poco para conseguir uan victoria tenia %d de fuerza y torpeza pero %d de punto Necesario!!\n",
							resultado, mision[i].getPuntuacionNecesaria());
				}
				flag = true;

				i = mision.length;

			}

		}
		if (!flag) {
			System.out.println("!! No encontrado ningun mision !!");

		}
	}

	private static void listarVillano() {
		System.out.println(v1.toString());
		System.out.println("!! Villanos Listado Corectamente !!");

	}

	private static void listarMision() {
		boolean flag = false;
		for (int i = 0; i < mision.length; i++) {
			if (mision[i] != null) {
				System.out.printf("**%s**\n", mision[i]);
				if (i == mision.length - 1) {
					System.out.println("!! Misiones Listado Corectamente !!");
				}
				flag = true;
			}

		}
		if (!flag) {
			System.out.println("no tienes Mision creado para listar!!");
		}
	}

	private static void crearVillano() {
		System.out.print("Introduce Un Villano: ");
		String nombre = sl.nextLine();
		System.out.println("Introduce su nivel de Maldad: ");
		int nivelMaldad = sc.nextInt();
		v1 = new Villano(nombre, nivelMaldad);
		v1.reclutarMinions();
		System.out.println("Villano creado correctamente!!");
		System.out.println("Minions reclutado correctamente!!");

	}

	public static void crearMisiones() {
		boolean flag = false;
		for (int i = 0; i < mision.length; i++) {
			if (mision[i] == null) {
				System.out.print("Introduce un nombre de mision:");
				String nombre = sl.nextLine();
				System.out.print("Introduce una descripcion para mision:");
				String descrip = sl.nextLine();
				System.out.print("Ingresa una puntuacion Necesario:");
				int puntuacion = sc.nextInt();
				mision[i] = new Mision(nombre, descrip, puntuacion);
				System.out.println("Mision Añadido Correctamente!!");
				i = mision.length;
				flag = true;
			}

		}
		if (!flag) {
			System.out.println("Tuvo un problema al hora de añadir Misión!!");
		}

	}

	private static void menu() {
		System.out.println("::::::: Menú Principal :::::::::");
		System.out.println("1. Crear Misiones ");
		System.out.println("2. Listar misiones");
		System.out.println("3. Listar Estedisticas Villano");
		System.out.println("4. Conseguir Victorias");
		System.out.println("5. Salir");
		System.out.print(">>>>>>>>>>>> ");

	}
}
