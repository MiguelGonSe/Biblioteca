import java.util.Scanner;

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
        System.out.println("Pulsa 1 para introducir usuario y contraseña. ");
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

        System.out.println("Bienvenido a Almendralejo Libreria Online ");
        System.out.println("Introduce tu usuario y contraseña ");

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
