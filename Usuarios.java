public class Usuarios {

    private int idUsuario; 
    private String nombre; 
    private boolean esAdmin;
    private int cantidadLibrosPrestados; 

    public Usuarios(){
        this.idUsuario = 0;
        this.nombre = "";
        this.esAdmin = false;
        this.cantidadLibrosPrestados = 0;
    }


    public Usuarios(int idUsuario, String nombre, boolean esAdmin) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.esAdmin = esAdmin;
    }


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

    public boolean esAdmin() { // is es para los boolean no get
        return esAdmin;
    }

    public void setesAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public void setCantidadLibrosPrestados(int cantidadLibrosPrestados){
        this.cantidadLibrosPrestados = cantidadLibrosPrestados;
    }

    public int getCantidadLibrosPrestados(){
        return this.cantidadLibrosPrestados;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "ID=" + idUsuario +
                ", Nombre='" + nombre + '\'' +
                ", Rol=" + (esAdmin ? "Administrador" : "Usuario") +
                '}';
    }

}
