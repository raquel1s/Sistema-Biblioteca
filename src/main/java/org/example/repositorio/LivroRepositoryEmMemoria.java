package org.example.repositorio;

import org.example.dominio.Livro;
import org.example.interfaces.ILivroRepository;

import java.util.ArrayList;

public class LivroRepositoryEmMemoria implements ILivroRepository {

    private ArrayList<Livro> livros;

    public LivroRepositoryEmMemoria() {
        this.livros = new ArrayList<>();
    }

    @Override
    public void salvar(Livro livro) {
        livros.add(livro);
    }

    @Override
    public void remover(String isbn) {
        livros.removeIf(l -> l.getIsbn().equals(isbn));
    }

    @Override
    public ArrayList<Livro> listarTodosLivros() {
        return livros;
    }

    @Override
    public Livro buscarLivroPorIsbn(String isbn) {
        for(Livro livro : livros) {
            if(livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }
}
