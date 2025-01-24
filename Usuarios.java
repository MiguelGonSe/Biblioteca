import java.util.Scanner;

public class Usuarios {
    private int idUsuario; // Identificador único del usuario
    private String nombre; // Nombre del usuario
    private boolean esAdmin; // Indica si es administrador

    // Constructor
    public Usuarios(int idUsuario, String nombre, boolean esAdmin) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;

        this.esAdmin = esAdmin;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAdmin() { // is es para los boolean no get
        return esAdmin;
    }

    // Método para registrar un nuevo usuario
    public static Usuarios registrarNuevoUsuario() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el ID del usuario: ");
        int idUsuario = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = sc.nextLine();

        System.out.print("¿Es administrador? (true/false): ");
        boolean esAdmin = sc.nextBoolean();

        Usuarios nuevoUsuario = new Usuarios(idUsuario, nombre, esAdmin);
        System.out.println("¡Usuario registrado con éxito!");
        return nuevoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID='" + idUsuario + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Rol=" + (esAdmin ? "Administrador" : "Usuario") +
                '}';
    }

}