import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        GestorUsuarios gestor = new GestorUsuarios();
        Usuarios Miguel = new Usuarios(1, "Miguel", true);
        Usuarios Juanfran = new Usuarios(2, "Juanfran", true);
        Usuarios Angel = new Usuarios(3, "Angel", false);
        Usuarios Alverto = new Usuarios(4, "Alverto", false);
        Usuarios Nicolas = new Usuarios(5, "Nicolas", false);
        Usuarios Ale = new Usuarios(6, "Ale", false);
        Usuarios Lucia = new Usuarios(7, "Lucia", false);
        Usuarios Rebeca = new Usuarios(8, "Rebeca", false);
        Usuarios Teresa = new Usuarios(9, "Teresa", false);
        Usuarios Gabino = new Usuarios(10, "Gabino", false);

        gestor.nuevoUsuario(Miguel);
        gestor.nuevoUsuario(Juanfran);
        gestor.nuevoUsuario(Angel);
        gestor.nuevoUsuario(Alverto);
        gestor.nuevoUsuario(Nicolas);
        gestor.nuevoUsuario(Ale);
        gestor.nuevoUsuario(Lucia);
        gestor.nuevoUsuario(Rebeca);
        gestor.nuevoUsuario(Teresa);
        gestor.nuevoUsuario(Gabino);

        while (!salir) {
            System.out.println("\n=== Sistema de Gestión de Biblioteca Digital ===");
            System.out.println("1. Gestión de Libros");
            System.out.println("2. Gestión de Usuarios");
            System.out.println("3. Gestión de Préstamos");
            System.out.println("4. Estadísticas y Reportes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    menuLibros(sc);
                    break;
                case 2:
                    menuUsuarios(sc);
                    break;
                case 3:
                    menuPrestamos(sc);
                    break;
                case 4:
                    menuEstadisticas(sc);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        sc.close();
    }

    // Submenú para Gestión de Libros
    private static void menuLibros(Scanner sc) {
        System.out.println("\n--- Gestión de Libros ---");
        System.out.println("1. Agregar libro (admin)");
        System.out.println("2. Eliminar libro (admin)");
        System.out.println("3. Buscar libro");
        System.out.println("4. Mostrar todos los libros");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.println("Función para agregar libro.");
                break;
            case 2:
                System.out.println("Función para eliminar libro.");
                break;
            case 3:
                System.out.println("Función para buscar libro.");
                break;
            case 4:
                System.out.println("Función para mostrar todos los libros.");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    // Submenú para Gestión de Usuarios
    private static void menuUsuarios(Scanner sc) {
        System.out.print("Ingrese su ID de usuario para iniciar sesión: ");
        int idSesion = sc.nextInt();
        sc.nextLine();

        gestor.iniciarSesion(idSesion);
        System.out.println("\n--- Gestión de Usuarios ---");
        System.out.println("1. Registrar nuevo usuario (admin)");
        System.out.println("2. Consultar usuarios registrados (admin)");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.println("Función para registrar usuario.");
                break;
            case 2:
                System.out.println("Función para consultar usuarios.");

                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    // Submenú para Gestión de Préstamos
    private static void menuPrestamos(Scanner sc) {
        System.out.println("\n--- Gestión de Préstamos ---");
        System.out.println("1. Realizar préstamo");
        System.out.println("2. Devolver libro");
        System.out.println("3. Mostrar libros prestados (admin)");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.println("Función para realizar préstamo.");
                break;
            case 2:
                System.out.println("Función para devolver libro.");
                break;
            case 3:
                System.out.println("Función para mostrar libros prestados.");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    // Submenú para Estadísticas y Reportes
    private static void menuEstadisticas(Scanner sc) {
        System.out.println("\n--- Estadísticas y Reportes ---");
        System.out.println("1. Número de préstamos totales y activos");
        System.out.println("2. Libros más prestados");
        System.out.println("3. Usuario con más préstamos activos");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.println("Función para mostrar número de préstamos.");
                break;
            case 2:
                System.out.println("Función para listar libros más prestados.");
                break;
            case 3:
                System.out.println("Función para mostrar usuario con más préstamos activos.");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }
}