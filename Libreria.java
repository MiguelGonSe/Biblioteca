public class Libreria{

    private Libro[] libros;
    private int capacidad;
    private static final int tamaño = 50;

    public Libreria() {

        libros = new Libro[tamaño];
        capacidad = 0;
    }

    public void añadirLibro(Libro a) {

        if (capacidad < tamaño){
            libros[capacidad] = a;
            capacidad++;
        }
    }

    private int buscarLibroTitulo(String titulo) {
        int busqueda = -1; //Se inicializa con -1, que indica que el libro no se ha encontrado. 

        for (int i = 0; i < capacidad && busqueda == -1; i++) { //Buscar -1 para parar cuando encuentre la cancion deseada y sales del for.
            if (libros[i].getTitulo().equals(titulo)) {
                busqueda = i;
            }
        }
        return busqueda; // Si es -1 no has encontrado.
    }

    private int buscarLibroAutor(String autor) {
        int busqueda = -1;  

        for (int i = 0; i < capacidad && busqueda == -1; i++) { 
            if (libros[i].getAutor().equals(autor)) {
                busqueda = i;
            }
        }
        return busqueda;
    }

    private int buscarLibroCategoria(String categoria) {
        int busqueda = -1; 

        for (int i = 0; i < capacidad && busqueda == -1; i++) { 
            if (libros[i].getCategoria().equals(categoria)) {
                busqueda = i;
            }
        }
        return busqueda;
    }

    public boolean eliminarLibro(String titulo) {
        int indice = buscarLibroTitulo(titulo);
        if (indice != -1) { //Si el índice es diferente de -1, significa que el libro fue encontrado en el arreglo (Como anterior)
            for (int i = indice; i < capacidad - 1; i++) {
                libros[i] = libros[i + 1]; //El propósito de este bucle es sobrescribir el libro que se desea eliminar
            }
            libros[ --capacidad ] = null;     //La última posición válida del arreglo se marca como Null. Se decrementa la capacidad
            return true; 
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String stringLibro = ""; //Creamos el String libro por defecto.
        for (int i = 0; i < capacidad; i++) {
            stringLibro += libros[i].toString() + "\n"; //Vamos añadiendo libros+toString
        }
        return stringLibro;
    }

    //Primer método toString (no estático)
    //Libro[] libros = {new Libro("1984", "George Orwell"), new Libro("Cien años de soledad", "Gabriel García Márquez")};
    //Biblioteca biblioteca = new Biblioteca(libros, 2);
    //System.out.println(biblioteca.toString()); 

    public static String toString(Libro[] arrayLibros) {
        String stringLibro = "";
        for (int i = 0; i < arrayLibros.length; i++) {
            stringLibro += arrayLibros[i].toString() + "\n";
        }
        return stringLibro;
    }

    //Segundo método toString (estático)
    //Libro[] libros = {new Libro("1984", "George Orwell"), new Libro("Cien años de soledad", "Gabriel García Márquez")};
    //System.out.println(Libreria.toString(libros));

}
