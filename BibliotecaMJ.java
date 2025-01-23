public class BibliotecaMJ {
    public static void main(String[] args) {
        GestorUsuarios gestorUsuarios = new GestorUsuarios();

        // Agregar usuarios
        gestorUsuarios.registrarUsuario("U001", "Alice", "alice@mail.com", true);
        gestorUsuarios.registrarUsuario("U002", "Bob", "bob@mail.com", false);

        // Mostrar usuarios registrados
        gestorUsuarios.mostrarUsuarios();

        // Buscar un usuario por ID
        Usuario usuarioEncontrado = gestorUsuarios.buscarUsuarioPorId("U002");
        if (usuarioEncontrado != null) {
            System.out.println("Usuario encontrado: " + usuarioEncontrado);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
}
