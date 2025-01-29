public class Libreria{

    private Libro[] libros;
    private int cantidadLibros = 50;

    public Libreria() {

        libros = new Libro[] {
            new Libro(1, "El senior de los anillos", "Aventuras", "Tolkien", false),
            new Libro(2, "1984", "Historia", "George Orwell", false),
            new Libro(3, "Cien anios de soledad", "Drama", "Gabriel García Márquez", false),
            new Libro(4, "Don Quijote de la Mancha", "Historia", "Miguel de Cervantes", false),
            new Libro(5, "Harry Potter y la piedra filosofal", "Fantasía", "J.K. Rowling", false),
            new Libro(6, "El principito", "Fantasía", "Antoine de Saint-Exupéry", false),
            new Libro(7, "Cronica de una muerte anunciada", "Misterio", "Gabriel García Márquez", false),
            new Libro(8, "Orgullo y prejuicio", "Romance", "Jane Austen", false),
            new Libro(9, "Fahrenheit 451", "Ciencia ficción", "Ray Bradbury", false),
            new Libro(10, "Los juegos del hambre", "Aventuras", "Suzanne Collins", false),
            new Libro(11, "Matar a un ruisenior", "Drama", "Harper Lee", false),
            new Libro(12, "La sombra del viento", "Misterio", "Carlos Ruiz Zafón", false),
            new Libro(13, "El hobbit", "Aventuras", "Tolkien", false),
            new Libro(14, "Dracula", "Terror", "Bram Stoker", false),
            new Libro(15, "La divina comedia", "Historia", "Dante Alighieri", false)
        };
    }

    public void añadirLibro(Libro nuevoLibro){
        if(cantidadLibros == libros.length){
            Libro[] nuevoArray = new Libro[libros.length + 1];
            for(int i = 0; i < libros.length; i++){
                nuevoArray[i] = libros[i];
            }
            libros = nuevoArray;
        }
        libros[cantidadLibros] = nuevoLibro;
        cantidadLibros++;
    }



    public Libro buscarLibroTitulo(String titulo) {
        Libro busqueda = null; //Se inicializa con -1, que indica que el libro no se ha encontrado. 

        for (int i = 0; i < libros.length && busqueda == null; i++) { //Buscar -1 para parar cuando encuentre la cancion deseada y sales del for.
            if (libros[i].getTitulo().equals(titulo)) {
                busqueda = libros[i];
            }
        }
        return busqueda; // Si es -1 no has encontrado.
    }

    public int buscarLibroAutor(String autor) {
        int busqueda = -1;  

        for (int i = 0; i < libros.length && busqueda == -1; i++) { 
            if (libros[i].getAutor().equals(autor)) {
                busqueda = i;
            }
        }
        return busqueda;
    }

    public int buscarLibroCategoria(String categoria) {
        int busqueda = -1; 

        for (int i = 0; i < libros.length && busqueda == -1; i++) { 
            if (libros[i].getCategoria().equals(categoria)) {
                busqueda = i;
            }
        }
        return busqueda;
    }

    public void mostrarLibros() {
        for (int i = 0; i < libros.length; i++) { 
            System.out.println(libros[i]);
        } 
    }

    public boolean eliminarLibro(String titulo) {
        for(int i = 0; i < libros.length; i++){
            if(libros[i].getTitulo().equals(titulo)){
                for(int j = 0; j < libros.length -1; j++){
                    libros[j] = libros [j + 1];
                }
                libros[cantidadLibros - 1] = null;
                cantidadLibros--;
                return true;
            }
        }
        return false;
    }
       

    public void mostrarLibrosPrestados(){

        for(int i = 0; i < libros.length; i++){
            if(libros[i].isPrestado()){
                System.out.println("Este libro está prestado " + libros[i].getTitulo());
            }
        }
    }

    public void mostrarLibrosmasPrestados(){
        int maximoUno = 0;
        int maximoDos = 0;
        Libro libroMaximo = null;
        Libro libroMinimo = null;

        for(int i = 0; i < libros.length; i++){
            Libro libroencontrado = libros[i];
            if(libros[i].getPrestamosTotales() > maximoUno){
                maximoUno = libroencontrado.getPrestamosTotales();
                libroMaximo = libroencontrado;
                maximoDos = maximoUno;
                libroMinimo = libroMaximo;

            } else if(libros[i].getPrestamosTotales() < maximoUno && libros[i].getPrestamosTotales() > maximoDos){
                maximoDos = libroencontrado.getPrestamosTotales();
                libroMinimo = libroencontrado;
            }
        }
        System.out.println(libroMaximo);
        System.out.println(libroMinimo);
    }

    @Override
    public String toString() {
        String stringLibro = ""; //Creamos el String libro por defecto.
        for (int i = 0; i < libros.length; i++) {
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
