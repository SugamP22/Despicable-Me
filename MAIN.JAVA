  
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // Scanner para capturar entradas de usuario
    private static Scanner sc = new Scanner(System.in); // Para números
    private static Scanner sl = new Scanner(System.in); // Para texto
    
    // Array para almacenar misiones
    private static Mision[] mision = new Mision[10];
    
    // Objeto Villano
    private static Villano v1;

    public static void main(String[] args) {
        crearVillano(); // Crear un villano al iniciar el programa
        int opcion = 0;
        
        do {
            menu(); // Mostrar menú principal
            try {
                opcion = sc.nextInt();
                switchmain(opcion); // Ejecutar la opción seleccionada
            } catch (InputMismatchException e) {
                sc.next(); // Limpiar el buffer en caso de error de entrada
            }
        } while (opcion != 5);
        
        System.out.println("\033[45mGracias por su Participacion\033[0m");
    }

    /**
     * Ejecuta la opción seleccionada en el menú.
     * @param opcion Número de la opción elegida
     */
    private static void switchmain(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("***** Crear Misiones *****");
                crearMisiones();
                break;
            case 2:
                System.out.println("***** Listar Misiones *****");
                listarMision();
                break;
            case 3:
                System.out.println("***** Listar Estadísticas del Villano *****");
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
                System.out.println("Opción no válida.");
                break;
        }
    }

    /**
     * Evalúa si el villano ha conseguido victorias basándose en la fuerza y torpeza de sus minions.
     */
    private static void conseguirVictorias() {
        int sumaTotalTorpeza = 0;
        int sumaTotalFuerza = 0;
        boolean flag = false;

        // Calcular la fuerza y torpeza total de los minions
        for (int i = 0; i < v1.getMinions().length; i++) {
            sumaTotalFuerza += v1.getMinions()[i].getFuerza();
            sumaTotalTorpeza += v1.getMinions()[i].getTorpeza();
        }

        int resultado = sumaTotalFuerza - sumaTotalTorpeza;
        System.out.println("Introduce un nombre de misión:");
        String nombre = sl.nextLine();

        // Buscar la misión en el array
        for (int i = 0; i < mision.length; i++) {
            if (mision[i] != null && mision[i].getNombre().equalsIgnoreCase(nombre)) {
                if (resultado > mision[i].getPuntuacionNecesaria()) {
                    System.out.printf("¡¡Felicidades!! Has conseguido una victoria con %d fuerza y torpeza y %d puntuación necesaria.\n", resultado, mision[i].getPuntuacionNecesaria());
                    
                    // Eliminar la misión completada
                    mision[i] = null;
                    for (int j = i; j < mision.length - 1; j++) {
                        mision[j] = mision[j + 1];
                    }
                    mision[mision.length - 1] = null;
                    
                    v1.setNivelVictorias(v1.getNivelVictorias() + 1);
                } else {
                    System.out.printf("¡¡Buen intento!! Te faltó poco para la victoria. Tuviste %d de fuerza y torpeza, pero se requerían %d puntos.\n", resultado, mision[i].getPuntuacionNecesaria());
                }
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("¡¡No se encontró ninguna misión con ese nombre!!");
        }
    }

    /**
     * Muestra la información del villano.
     */
    private static void listarVillano() {
        System.out.println(v1.toString());
        System.out.println("¡¡Villano listado correctamente!!");
    }

    /**
     * Lista todas las misiones disponibles.
     */
    private static void listarMision() {
        boolean flag = false;
        for (Mision m : mision) {
            if (m != null) {
                System.out.printf("**%s**\n", m);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No tienes misiones creadas para listar!!");
        } else {
            System.out.println("¡¡Misiones listadas correctamente!!");
        }
    }

    /**
     * Crea un nuevo villano con nombre y nivel de maldad.
     */
    private static void crearVillano() {
        System.out.print("Introduce un nombre para el villano: ");
        String nombre = sl.nextLine();
        System.out.print("Introduce su nivel de maldad: ");
        int nivelMaldad = sc.nextInt();
        
        v1 = new Villano(nombre, nivelMaldad);
        v1.reclutarMinions();
        System.out.println("¡¡Villano creado correctamente!!");
        System.out.println("¡¡Minions reclutados correctamente!!");
    }

    /**
     * Crea nuevas misiones hasta llenar el array de misiones.
     */
    public static void crearMisiones() {
        boolean flag = false;
        for (int i = 0; i < mision.length; i++) {
            if (mision[i] == null) {
                System.out.print("Introduce un nombre para la misión: ");
                String nombre = sl.nextLine();
                System.out.print("Introduce una descripción para la misión: ");
                String descripcion = sl.nextLine();
                System.out.print("Introduce una puntuación necesaria: ");
                int puntuacion = sc.nextInt();
                
                mision[i] = new Mision(nombre, descripcion, puntuacion);
                System.out.println("¡¡Misión añadida correctamente!!");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("¡Hubo un problema al añadir la misión! No hay espacio disponible.");
        }
    }

    /**
     * Muestra el menú principal.
     */
    private static void menu() {
        System.out.println("::::::: Menú Principal :::::::::");
        System.out.println("1. Crear Misiones");
        System.out.println("2. Listar misiones");
        System.out.println("3. Listar Estadísticas del Villano");
        System.out.println("4. Conseguir Victorias");
        System.out.println("5. Salir");
        System.out.print(">>>>>>>>>>>> ");
    }
}
