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

        Libreria libreria = new Libreria();
    Libro libro1 = new Libro("1", "El señor de los anillos", "Aventuras", "Tolkien", false);
    Libro libro2 = new Libro("2", "1984", "Historia", "George Orwell", false);
    Libro libro3 = new Libro("3", "Cien años de soledad", "Drama", "Gabriel García Márquez", false);
    Libro libro4 = new Libro("4", "Don Quijote de la Mancha", "Historia", "Miguel de Cervantes", false);
    Libro libro5 = new Libro("5", "Harry Potter y la piedra filosofal", "Fantasía", "J.K. Rowling", false);
    Libro libro6 = new Libro("6", "El principito", "Fantasía", "Antoine de Saint-Exupéry", false);
    Libro libro7 = new Libro("7", "Crónica de una muerte anunciada", "Misterio", "Gabriel García Márquez", false);
    Libro libro8 = new Libro("8", "Orgullo y prejuicio", "Romance", "Jane Austen", false);
    Libro libro9 = new Libro("9", "Fahrenheit 451", "Ciencia ficción", "Ray Bradbury", false);
    Libro libro10 = new Libro("10", "Los juegos del hambre", "Aventuras", "Suzanne Collins", false);
    Libro libro11 = new Libro("11", "Matar a un ruiseñor", "Drama", "Harper Lee", false);
    Libro libro12 = new Libro("12", "La sombra del viento", "Misterio", "Carlos Ruiz Zafón", false);
    Libro libro13 = new Libro("13", "El hobbit", "Aventuras", "Tolkien", false);
    Libro libro14 = new Libro("14", "Drácula", "Terror", "Bram Stoker", false);
    Libro libro15 = new Libro("15", "La divina comedia", "Historia", "Dante Alighieri", false);


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