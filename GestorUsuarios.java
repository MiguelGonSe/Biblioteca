public class GestorUsuarios {

    private Usuarios[] usuarios;
    int capacidad = 10;

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

    public void añadirUsuario(Usuarios a) {
        if (capacidad < usuarios.length) {
            usuarios[capacidad] = a;
            capacidad++;
        } 
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
        Usuarios usuarioEncontrado = buscarUsuarioPorId(idUsuario);
        if (usuarioEncontrado != null) {
            for (int i = 0; i < usuarios.length - 1; i++) {
                usuarios[i] = usuarios[i + 1];
            }
            usuarios[--capacidad] = null; // Reducimos el tamaño y eliminamos la referencia al último elemento
            return true;
        }
        return false;
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
