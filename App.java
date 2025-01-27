import java.util.Scanner;
import java.util.Arrays;

public class App {
    
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("Dime que opción quieres ");
        System.out.println("Pulsa 1 para entrar en la aplicación. ");
        System.out.println("Pulsa 2 para salir de la aplicación. ");
        boolean seguir = true;
        while (seguir) {
            switch (sc.nextInt()) {
                case 1 -> entrar();
                case 2 -> salir();
                default -> seguir = false;
            }
        }
    }

    public static void entrar() {

        System.out.println("Bienvenido a Almendralejo Libreria Online, que deseas hacer ");
        System.out.println("Pulsa 1 para introducir ID del Usuario. ");
        System.out.println("Pulsa 2 para volver al menu. ");
        boolean seguir = true;
        while (seguir) {
            switch (sc.nextInt()) {
                case 1 -> entrar2();
                case 2 -> menu();
                default -> seguir = false;
            }
        }

    }

    public static void entrar2() {
        Scanner sc = new Scanner(System.in);
        
         // Crear usuarios
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
 
         // Crear instancia del gestor de usuarios
         GestorUsuarios gestor = new GestorUsuarios();
 
         // Añadir usuarios al gestor
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
 
         // Menú principal
         boolean continuar = true;
 
         while (continuar) {
             System.out.println("\n--- Biblioteca Digital ---");
             System.out.print("Ingrese su ID de usuario para iniciar sesión: ");
             int idSesion = sc.nextInt();
             sc.nextLine();
 
             gestor.iniciarSesion(idSesion);
 
             System.out.print("\n¿Desea continuar? (true/false): ");
             continuar = sc.nextBoolean();
         }
 
         sc.close();
         System.out.println("Gracias por usar la Biblioteca Digital. ¡Hasta pronto!");
     }

    public static void salir() {
        System.out.println("Has salido del programa. Esperamos verle pronto. ");
    }

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

}
