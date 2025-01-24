import java.util.Arrays;

/**
 * Clase que gestiona usuarios.
 *
 * @author M.J.
 */
public class GestorUsuarios {
    private Usuarios[] usuarios;
    private int totalUsuarios;
    private static final int TAM = 100;

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
            usuarios[totalUsuarios] = nuevoUsuario;
            totalUsuarios++;
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
