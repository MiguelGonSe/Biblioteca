public class Usuario {
    private String id; // Identificador único del usuario
    private String nombre; // Nombre del usuario
    private String correo; // Correo electrónico
    private boolean esAdmin; // Indica si es administrador

    // Constructor
    public Usuario(String id, String nombre, String correo, boolean esAdmin) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.esAdmin = esAdmin;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean isAdmin() {
        return esAdmin;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID='" + id + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Correo='" + correo + '\'' +
                ", Rol=" + (esAdmin ? "Administrador" : "Usuario") +
                '}';
    }
}
