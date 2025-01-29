public class GestorUsuarios {

    private Usuarios[] usuarios;
    int cantidadUsuarios = 50;

    public GestorUsuarios() {
        usuarios = new Usuarios[]{
            new Usuarios(1, "Miguel", true),
            new Usuarios(2, "Juanfran", true),
            new Usuarios(3, "Angel", false),
            new Usuarios(4, "Alberto", false),
            new Usuarios(5, "Nicolas", false),
            new Usuarios(6, "Ale", false),
            new Usuarios(7, "Lucia", false),
            new Usuarios(8, "Rebeca", false),
            new Usuarios(9, "Teresa", false),
            new Usuarios(10, "Gabino", false),
        };
    }

    public void añadirUsuario(Usuarios nuevoUsuario){
        if(cantidadUsuarios == usuarios.length){
            Usuarios[] nuevoArray = new Usuarios[usuarios.length + 1];
            for(int i = 0; i < usuarios.length; i++){
                nuevoArray[i] = usuarios[i];
            }
            usuarios = nuevoArray;
        }
        usuarios[cantidadUsuarios] = nuevoUsuario;
        cantidadUsuarios++;
    }

    public Usuarios buscarUsuarioPorId(int idUsuario) {
        Usuarios busqueda = null;

        for (int i = 0; i < usuarios.length && busqueda == null; i++) {
            if (usuarios[i].getIdUsuario() == idUsuario) {
                busqueda = usuarios[i];
            }
        }
        return busqueda;
    }

    
    public boolean eliminarUsuario(int idUsuario) {
        for(int i = 0; i < usuarios.length; i++){
            if(usuarios[i].getIdUsuario() == idUsuario){
                for(int j = 0; j < usuarios.length -1; j++){
                    usuarios[j] = usuarios [j + 1];
                }
                usuarios[cantidadUsuarios - 1] = null;
                cantidadUsuarios--;
                return true;
            }
        }
        return false;
    }

    public void mostrarUsuarios() {
        for (int i = 0; i < usuarios.length; i++) { 
            System.out.println(usuarios[i]);
        } 
    }

    public void mostrarUsuarioMasPrestamos() {
        int librosPrestados = 0;
        Usuarios usuarioMaximo = null;
        for (int i = 0; i < usuarios.length; i++) { 
            if(usuarios[i].getCantidadLibrosPrestados() > librosPrestados){
                librosPrestados = usuarios[i].getCantidadLibrosPrestados();
                usuarioMaximo = usuarios[i];
            }
        }
        System.out.println("El usuario con más libros prestados es: " + usuarioMaximo.getNombre());
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) { 
                resultado += usuarios[i] + "\n";
            }
        }
        return resultado;
    }
}
