import java.util.Arrays;
import java.util.Scanner;
/**
 * Clase que gestiona usuarios.
 *
 * @author M.J.
 */
public class GestorUsuarios {
    private Usuarios[] usuarios;
    private int totalUsuarios;
    private static final int TAM = 50;

    /**
     * Constructor que inicializa el gestor con un tamaño máximo predeterminado.
     */
    public GestorUsuarios() {
        usuarios = new Usuarios[TAM];
        totalUsuarios = 0;
    }

    /**
     * Añade un nuevo usuario al gestor.
     *
     * @param nuevoUsuario el usuario a añadir.
     */
    public void nuevoUsuario(Usuarios nuevoUsuario) {
        if (totalUsuarios < TAM) {
            if (buscarUsuarioPorId(nuevoUsuario.getIdUsuario()) == null) {
                usuarios[totalUsuarios] = nuevoUsuario;
                totalUsuarios++;
            } else {
                System.out.println("El usuario con ID " + nuevoUsuario.getIdUsuario() + " ya existe.");
            }
        } else {
            System.out.println("No se pueden agregar más usuarios. Capacidad máxima alcanzada.");
        }
    }

    /**
     * Busca el índice de un usuario por su ID.
     *
     * @param idUsuario el ID del usuario a buscar.
     * @return el índice del usuario, o -1 si no se encuentra.
     */
    private int buscarIndiceUsuario(int idUsuario) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getIdUsuario() == idUsuario) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param idUsuario el ID del usuario a buscar.
     * @return el usuario encontrado, o null si no se encuentra.
     */
    public Usuarios buscarUsuarioPorId(int idUsuario) {
        int indice = buscarIndiceUsuario(idUsuario);
        return (indice != -1) ? usuarios[indice] : null;
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param idUsuario el ID del usuario a eliminar.
     * @return true si el usuario se eliminó correctamente, false en caso contrario.
     */
    public boolean eliminarUsuario(int idUsuario) {
        int indice = buscarIndiceUsuario(idUsuario);
        if (indice != -1) {
            for (int i = indice; i < totalUsuarios - 1; i++) {
                usuarios[i] = usuarios[i + 1];
            }
            usuarios[--totalUsuarios] = null; // Reducimos el tamaño y eliminamos la referencia al último elemento
            return true;
        }
        return false;
    }

    public void consultarHistorialUsuarios() {
        if (totalUsuarios == 0) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Historial de usuarios registrados:");
            for (int i = 0; i < totalUsuarios; i++) {
                System.out.println(usuarios[i]);
            }
        }
    }
    public void iniciarSesion(int idUsuario) {
        Usuarios usuario = buscarUsuarioPorId(idUsuario);
        if (usuario != null) {
            if (usuario.isAdmin()) {
                mostrarMenuAdministrador(usuario);
                System.out.println("Bienvenido, Administrador " + usuario.getNombre());
            } else {
                mostrarMenuUsuario(usuario);
                System.out.println("Bienvenido, Usuario " + usuario.getNombre());
            }
        } else {
            System.out.println("Usuario con ID " + idUsuario + " no encontrado.");
        }
    }
    private void mostrarMenuAdministrador(Usuarios admin) {
        System.out.println("\nBienvenido, Administrador " + admin.getNombre());
        boolean continuar = true;
        Scanner sc = new Scanner(System.in);

        while (continuar) {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Crear nuevo usuario");
            System.out.println("2. Consultar historial de usuarios");
            System.out.println("3. Buscar usuario por ID");
            System.out.println("4. Eliminar usuario por ID");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del usuario: ");
                    int idUsuario = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombre = sc.nextLine();

                    System.out.print("¿Es administrador? (true/false): ");
                    boolean esAdmin = sc.nextBoolean();

                    Usuarios nuevoUsuario = new Usuarios(idUsuario, nombre, esAdmin);
                    nuevoUsuario(nuevoUsuario);
                    System.out.println("Usuario agregado exitosamente.");
                    break;

                case 2:
                    consultarHistorialUsuarios();
                    break;

                case 3:
                    System.out.print("Ingrese el ID del usuario a buscar: ");
                    int idBuscar = sc.nextInt();
                    Usuarios usuarioEncontrado = buscarUsuarioPorId(idBuscar);

                    if (usuarioEncontrado != null) {
                        System.out.println("Usuario encontrado: " + usuarioEncontrado);
                    } else {
                        System.out.println("Usuario con ID " + idBuscar + " no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID del usuario a eliminar: ");
                    int idEliminar = sc.nextInt();
                    boolean eliminado = eliminarUsuario(idEliminar);

                    if (eliminado) {
                        System.out.println("Usuario eliminado exitosamente.");
                    } else {
                        System.out.println("Usuario con ID " + idEliminar + " no encontrado.");
                    }
                    break;

                case 5:
                    continuar = false;
                    System.out.println("Saliendo del menú administrador...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }private void mostrarMenuUsuario(Usuarios usuario) {
        System.out.println("\nBienvenido, Usuario " + usuario.getNombre());
        boolean continuar = true;
        Scanner sc = new Scanner(System.in);

        while (continuar) {
            System.out.println("\n--- Menú Usuario ---");
            System.out.println("1. Consultar perfil");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nPerfil del usuario:");
                    System.out.println(usuario);
                    break;

                case 2:
                    continuar = false;
                    System.out.println("Saliendo del menú usuario...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    /**
     * Devuelve una representación en cadena de todos los usuarios.
     *
     * @return una cadena con los usuarios.
     */
    @Override
    public String toString() {
        String resultado = "";
        for (Usuarios usuario : usuarios) {
            if (usuario != null) { // Verificamos que el usuario no sea nulo
                resultado += usuario + "\n";
            }
        }
        return resultado;
    }
}
