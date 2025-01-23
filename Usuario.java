public class Usuarios {
    private String id; // Identificador único del usuario
    private String nombre; // Nombre del usuario
     // Correo electrónico
    private boolean esAdmin; // Indica si es administrador

    // Constructor
    public Usuarios(String id, String nombre, boolean esAdmin) {
        this.id = id;
        this.nombre = nombre;
        
        this.esAdmin = esAdmin;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setid(String id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }



    public boolean isAdmin() { // is es para los boolean no get
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
public class Usuario {
    private int id;
    private String nombre;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
