import java.util.ArrayList;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios;

    public GestorUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    // Registrar un nuevo usuario
    public void registrarUsuario(String id, String nombre, String correo, boolean esAdmin) {
        Usuario nuevoUsuario = new Usuario(id, nombre, correo, esAdmin);
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario registrado: " + nombre);
    }

    // Consultar todos los usuarios
    public void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios registrados:");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    // Buscar un usuario por ID
    public Usuario buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
}
