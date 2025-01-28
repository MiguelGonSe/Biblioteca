import java.util.Scanner;

public class Usuarios {
    private int comtraseña; // Identificador único del usuario
    private String nombre; // Nombre del usuario
    private boolean esAdmin; // Indica si es administrador

    // Constructor
    public Usuarios(int contraseña, String nombre, boolean esAdmin) {
        this.comtraseña = contraseña;
        this.nombre = nombre;
        this.esAdmin = esAdmin;
    }

    // Getters y Setters
    public int getComtraseña() {
        return comtraseña;
    }

    public void setComtraseña(int contraseña) {
        this.comtraseña = contraseña;
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
                "ID=" + comtraseña +
                ", Nombre='" + nombre + '\'' +
                ", Rol=" + (esAdmin ? "Administrador" : "Usuario") +
                '}';
    }
}
