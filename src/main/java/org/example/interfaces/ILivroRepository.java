package org.example.interfaces;

import org.example.dominio.Livro;

import java.util.ArrayList;

public interface ILivroRepository {

    void salvar(Livro livro);
    void remover(String isbn);
    ArrayList<Livro> listarTodosLivros();
    Livro buscarLivroPorIsbn(String isbn);
}
