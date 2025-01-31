/**
 * Almendralejo Libreria Online.
 * 
 * @author Miguel González y Juan Francisco Hurtado
 * @version 3.0
 */

import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);
    private static GestorUsuarios gestorUsuarios = new GestorUsuarios();
    private static Libreria libreria = new Libreria();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("Dime que opción quieres ");
        System.out.println("Pulsa 1 para entrar en la aplicación. ");
        System.out.println("Pulsa 2 para salir de la aplicación. ");
        boolean seguir = true;
        while (seguir) {
            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> entrar();
                case 2 -> salir();
                default -> seguir = false;
            }
        }
        sc.close();
    }

    public static void entrar() {

        System.out.println("Bienvenido a Almendralejo Libreria Online, que deseas hacer ");
        System.out.println("Pulsa 1 para introducir el Id de usuario. ");
        System.out.println("Pulsa 2 para salir. ");
        boolean seguir = true;
        while (seguir) {
            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> entrar2();
                case 2 -> salir();
                default -> seguir = false;
            }
        }
        sc.close();
    }

    public static void entrar2() {
        System.out.println("Bienvenido a Almendralejo Libreria Online ");
        System.out.println("Introduce tu Id de usuario: ");
        int ID = Integer.parseInt(sc.nextLine());
        Usuarios encontrado = gestorUsuarios.buscarUsuarioPorId(ID);
        if (encontrado != null) {
            if (encontrado.esAdmin()) {
                menuAdmin();
            } else {
                menuUsuario();
            }

        } else {
            System.out.println("El Id de usuario no existe.");
        }
        sc.close();
    }

    public static void menuAdmin() {
        System.out.println("Bienvenido Administrador. ¿Qué deseas hacer? ");
        System.out.println("Pulsa 1 para agregar un libro nuevo. ");
        System.out.println("Pulsa 2 para eliminar libros existentes. ");
        System.out.println("Pulsa 3 para buscar libro por titulo, autor o categoria. ");
        System.out.println("Pulsa 4 para mostrar todos los libros disponibles. ");
        System.out.println("Pulsa 5 para registrar nuevos usuarios. ");
        System.out.println("Pulsa 6 para consultar información de los nuevos usuarios. ");
        System.out.println("Pulsa 7 para realizar un prestamo de libro. ");
        System.out.println("Pulsa 8 para devolver un libro. ");
        System.out.println("Pulsa 9 para mostrar los libros prestados. ");
        System.out.println("Pulsa 10 para mostrar todos los usuarios registrados. ");
        System.out.println("Pulsa 11 para mostrar el usuario con más préstamos activos. ");
        System.out.println("Pulsa 12 para salir de la aplicación. ");
        boolean seguir = true;
        while (seguir) {
            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> agregarLibro();
                case 2 -> eliminarLibro();
                case 3 -> buscarLibro();
                case 4 -> mostrarLibros();
                case 5 -> registrarUsuario();
                case 6 -> verUsuarios();
                case 7 -> prestarLibro();
                case 8 -> devolverLibro();
                case 9 -> mostrarLibrosPrestados();
                case 10 -> mostrarUsuarios();
                case 11 -> mostrarUsuarioConMasPrestamosActivos();
                case 12 -> salir();
                default -> seguir = false;
            }
        }
        sc.close();
    }

    public static void menuUsuario() {
        System.out.println("Bienvenido Usuario. ¿Qué desea hacer? ");
        System.out.println("Pulsa 1 para buscar libro por titulo, autor o categoria. ");
        System.out.println("Pulsa 2 para mostrar todos los libros disponibles. ");
        System.out.println("Pulsa 3 para coger pestado libro. ");
        System.out.println("Pulsa 4 para devolver un libro. ");
        System.out.println("Pulsa 5 para salir de la aplicación. ");
        boolean seguir = true;
        while (seguir) {
            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> buscarLibro();
                case 2 -> mostrarLibros();
                case 3 -> prestarLibro();
                case 4 -> devolverLibro();
                case 5 -> salir();
                default -> seguir = false;
            }
        }
        sc.close();
    }

    public static void agregarLibro() {

        System.out.println("Perfecto. Has elegido agregar libro. ");
        System.out.println("Dame un ISBN: ");
        int ISBN = Integer.parseInt(sc.nextLine());
        System.out.println("Dame un título: ");
        String titulo = sc.nextLine();
        System.out.println("Dame una categoria: ");
        String categoria = sc.nextLine();
        System.out.println("Dame su autor: ");
        String autor = sc.nextLine();
        libreria.añadirLibro(new Libro(ISBN, titulo, categoria, autor, false));
        System.out.println("Correcto. Libro añadido.");
    }

    public static void eliminarLibro() {

        System.out.println("Perfecto. Has elegido eliminar libro. Elige el titulo del libro que deseas eliminar: ");
        String tituloLibro = sc.nextLine();
        libreria.eliminarLibro(tituloLibro);
        System.out.println("Correcto. Libro eliminado");

    }

    public static void buscarLibro() {
        System.out.println("Has elegido buscar libro; de qué manera quieres buscar el libro: ");
        System.out.println("Si pulsas 1 lo quieres buscar por titulo: ");
        System.out.println("Si pulsas 2 lo quieres buscar por autor: ");
        System.out.println("Si pulsas 3 lo quieres buscar por categoria: ");
        System.out.println("Si pulsas 4, vuelves al menú: ");
        boolean seguir = true;
        while (seguir) {
            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> buscarTitulo();
                case 2 -> buscarAutor();
                case 3 -> buscarCategoria();
                case 4 -> menuAdmin();
                default -> seguir = false;
            }
        }
        sc.close();
    }

    public static void buscarTitulo() {

        System.out.println("Dime el titulo del libro que deseas buscar ");
        String tituloLibro = sc.nextLine();
        libreria.buscarLibroTitulo(tituloLibro);
        System.out.println(tituloLibro);
    }

    public static void buscarAutor() {

        System.out.println("Dame el autor del libro que deseas buscar ");
        String autorLibro = sc.nextLine();
        libreria.buscarLibroTitulo(autorLibro);
        System.out.println(autorLibro);
    }

    public static void buscarCategoria() {

        System.out.println("Dame la categoria del libro que deseas buscar ");
        String categoriaLibro = sc.nextLine();
        libreria.buscarLibroTitulo(categoriaLibro);
        System.out.println(categoriaLibro);
    }

    public static void mostrarLibros() {

        System.out.println("Has elegido mostrar todos los libros registrados. ");
        libreria.mostrarLibros();
    }

    public static void mostrarUsuarios() {

        System.out.println("Has elegido mostrar todos los usuarios registrados. ");
        gestorUsuarios.mostrarUsuarios();
    }

    public static void registrarUsuario() {
        System.out.println("Has elegido registrar usuario. Dame el ID del usuario ");
        int idUsuario = Integer.parseInt(sc.nextLine());
        System.out.println("Ahora dame el nombre del usuario");
        String nombreUsuario = sc.nextLine();
        System.out.println("¿Quieres que sea administrador? (true/false)");
        boolean esAdmin = sc.nextBoolean();
        gestorUsuarios.añadirUsuario(new Usuarios(idUsuario, nombreUsuario, esAdmin));
        System.out.println("Correcto, usuario guardado.");

    }

    public static void verUsuarios() {
        System.out.println("Has elegido ver a los usuarios.");
        System.out.println("Si pulsas 1 si quieres ver un usuario. ");
        System.out.println("Si pulsas 2 si quieres ver todos los usuarios registrados. ");
        boolean seguir = true;
        while (seguir) {
            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> verUsuario();
                case 2 -> verTodosLosUsuarios();
                case 3 -> eliminarUsuario();
                default -> seguir = false;
            }
        }
        sc.close();
    }

    public static void verUsuario() {

        System.out.println("Dame el ID del usuario que quieras ver: ");
        int idUsuario = Integer.parseInt(sc.nextLine());
        Usuarios usuarioEncontrado = gestorUsuarios.buscarUsuarioPorId(idUsuario);
        System.out.println(usuarioEncontrado.getNombre());
    }

    public static void verTodosLosUsuarios() {

        System.out.println("Te muestro todos los usuarios registrados en la aplicacion: ");
        String todosUsuarios = gestorUsuarios.toString();
        System.err.println(todosUsuarios);
    }

    public static void eliminarUsuario() {

        System.out.println("Dame el usuario que quieras borrar: ");
        System.out.println("Por ejemplo, si quieres borrar el usuario con el ID1, pulsa 1 ");
        int idUsuario = Integer.parseInt(sc.nextLine());
        boolean eliminado = gestorUsuarios.eliminarUsuario(idUsuario);
        if (eliminado) {
            System.err.println("Correcto, usuario eliminado");
        } else {
            System.out.println("Incorrecto, usuario no eliminado.");
        }
    }

    public static void prestarLibro() {

        System.out
                .println("Has elegido coger prestado el libro. Dime el titulo del libro que quieras coger prestado: ");
        String tituloLibro = sc.nextLine();
        Libro libroPrestado = libreria.buscarLibroTitulo(tituloLibro);
        if (libroPrestado != null) {
            System.out.println("A que usuario le vamos a prestar el libro: ");
            int idUsuario = Integer.parseInt(sc.nextLine());
            Usuarios usuarioEncontrado = gestorUsuarios.buscarUsuarioPorId(idUsuario);
            if (usuarioEncontrado != null) {
                usuarioEncontrado.setCantidadLibrosPrestados(usuarioEncontrado.getCantidadLibrosPrestados() + 1);
                libroPrestado.prestar();
            } else {
                System.out.println("El usuario no existe. ");
            }
        } else {
            System.out.println("Libro no encontrado. ");
        }
    }

    public static void devolverLibro() {
        System.out.println("Has elegido devolver el libro. Dime el titulo del libro que quieras devolver ");
        String tituloLibro = sc.nextLine();
        Libro libroDevuelto = libreria.buscarLibroTitulo(tituloLibro);
        if (libroDevuelto != null) {
            System.out.println("A que usuario le vamos a prestar el libro: ");
            int idUsuario = Integer.parseInt(sc.nextLine());
            Usuarios usuarioEncontrado = gestorUsuarios.buscarUsuarioPorId(idUsuario);
            if (usuarioEncontrado != null) {
                if(usuarioEncontrado.getCantidadLibrosPrestados() > 0){
                    usuarioEncontrado.setCantidadLibrosPrestados(usuarioEncontrado.getCantidadLibrosPrestados() - 1);
                    libroDevuelto.devolver();
                } else {
                    System.out.println("Este usuario todavia no ha cogido prestado un libro. ");
                }
            } else {
                System.out.println("El usuario no existe. ");
            }
        } else {
            System.out.println("Libro no encontrado. ");
        }
    }

    public static void mostrarLibrosPrestados() {
        System.out.println("Estos son los libros prestados actualmente: ");
        libreria.mostrarLibrosPrestados();
        System.out.println("Estos dos son los libros más prestados: ");
        libreria.mostrarLibrosmasPrestados();
    }

    public static void mostrarUsuarioConMasPrestamosActivos() {
        gestorUsuarios.mostrarUsuarioMasPrestamos();
    }

    public static void salir() {
        System.out.println("Has salido del programa. Esperamos verle pronto. ");
    }

}
