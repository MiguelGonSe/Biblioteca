public class Libro {

    private String ISBN;
    private String titulo;
    private String categoria;
    private String autor;
    private Boolean prestado;
    private int prestamosTotales = 0;

    public Libro() {
        this.ISBN = "";
        this.titulo = "";
        this.categoria = "";
        this.autor = "";
        this.prestado = false;
    }

    public Libro(String ISBN, String titulo, String categoria, String autor, Boolean pestado) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.categoria = categoria;
        this.autor = autor;
        this.prestado = false;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Boolean isPrestado() {
        return this.prestado;
    }

    public Boolean getPrestado() {
        return this.prestado;
    }

    public void setPrestado(Boolean prestado) {
        this.prestado = prestado;
    }

    public void prestar(){
        if(this.prestado){
            System.out.println("Este libro ya está prestado");
        } else {
            this.prestado = true;
            System.out.println("Este libro ya se ha prestado.");
        }
        prestamosTotales++;
    }

    public void devolver(){
        if(!this.prestado){
            System.out.println("Este libro no está prestado");
        } else {
            this.prestado = false;
            System.out.println("Este libro se ha devuelto.");
        }
        prestamosTotales--;
    }

    @Override   
    public String toString() {  
        
        String mensaje = "El libro " + this.ISBN + " con título " + this.titulo + " y autor " + this.autor + " ";

        if(!this.prestado){
            mensaje += "no está prestado";
        } else {
            mensaje += "este libro está prestado";
        }
        return mensaje;
    }

    

}
