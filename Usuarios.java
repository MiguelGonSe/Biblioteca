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

    public void setid(int idUsuario) {
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

    @Override
    public String toString() {
        return "Usuario{" +
                "ID='" + idUsuario + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Rol=" + (esAdmin ? "Administrador" : "Usuario") +
                '}';
    }
}