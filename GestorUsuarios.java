import java.util.Arrays;
import java.util.Scanner;


public class GestorUsuarios {
    private Usuarios[] usuarios;
    private int totalUsuarios;
    private static final int TAM = 50;

  
    public GestorUsuarios() {
        usuarios = new Usuarios[TAM];
        totalUsuarios = 0;
    }

   
    public void nuevoUsuario(Usuarios nuevoUsuario) {
        if (totalUsuarios < TAM) {
            if (buscarUsuarioPorContraseña(nuevoUsuario.getComtraseña()) == null) {
                usuarios[totalUsuarios] = nuevoUsuario;
                totalUsuarios++;
            } else {
                System.out.println("El usuario con contraseña " + nuevoUsuario.getComtraseña() + " ya existe.");
            }
        } else {
            System.out.println("No se pueden agregar más usuarios. Capacidad máxima alcanzada.");
        }
    }


    private int buscarContraseñaUsuario(int contraseña) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getComtraseña() == contraseña) {
                return i;
            }
        }
        return -1;
    }


    public Usuarios buscarUsuarioPorContraseña(int contraseña) {
        int Contraseña = buscarContraseñaUsuario(contraseña);
        return (Contraseña != -1) ? usuarios[Contraseña] : null;
    }


    public boolean eliminarUsuario(int contraseña) {
        int Contraseña = buscarContraseñaUsuario(contraseña);
        if (Contraseña != -1) {
            for (int i = Contraseña; i < totalUsuarios - 1; i++) {
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

    public void iniciarSesion(int contraseña) {
        Usuarios usuario = buscarUsuarioPorContraseña(contraseña);
        if (usuario != null) {
            if (usuario.isAdmin()) {
                mostrarMenuAdministrador(usuario);
                System.out.println("Bienvenido, Administrador " + usuario.getNombre());
            } else {
                mostrarMenuUsuario(usuario);
                System.out.println("Bienvenido, Usuario " + usuario.getNombre());
            }
        } else {
            System.out.println("Usuario con Contraseña " + contraseña + " no encontrado.");
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
                    System.out.print("Ingrese la contraseña del usuario: ");
                    int contraseña = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombre = sc.nextLine();

                    System.out.print("¿Es administrador? (true/false): ");
                    boolean esAdmin = sc.nextBoolean();

                    Usuarios nuevoUsuario = new Usuarios(contraseña, nombre, esAdmin);
                    nuevoUsuario(nuevoUsuario);
                    System.out.println("Usuario agregado exitosamente.");
                    break;

                case 2:
                    consultarHistorialUsuarios();
                    break;

                case 3:
                    System.out.print("Ingrese el contraseña del usuario a buscar: ");
                    int buscarContraseña = sc.nextInt();
                    Usuarios usuarioEncontrado = buscarUsuarioPorContraseña(buscarContraseña);

                    if (usuarioEncontrado != null) {
                        System.out.println("Usuario encontrado: " + usuarioEncontrado);
                    } else {
                        System.out.println("Usuario con contraseña " + buscarContraseña + " no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la contraseña del usuario a eliminar: ");
                    int eliminarContaseña = sc.nextInt();
                    boolean eliminado = eliminarUsuario(eliminarContaseña);

                    if (eliminado) {
                        System.out.println("Usuario eliminado exitosamente.");
                    } else {
                        System.out.println("Usuario con contraseña " + eliminarContaseña + " no encontrado.");
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
    }

    private void mostrarMenuUsuario(Usuarios usuario) {
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
