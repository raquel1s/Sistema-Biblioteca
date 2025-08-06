package org.example.dominio;

public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel;

    public Livro(int id, String titulo, String autor, String isbn, boolean disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = disponivel;
    }

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String toString() {
        return "Título: " + this.titulo +
                "\nAutor: " + this.autor +
                "\nISBN: " + this.isbn +
                "\nDisponivel: " + (this.disponivel ? "Sim" : "Não");
    }

    public boolean getDisponivel() {
        return false;
    }
}
