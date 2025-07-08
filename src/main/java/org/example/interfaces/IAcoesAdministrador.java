package org.example.interfaces;

import org.example.dominio.Livro;

public interface IAcoesAdministrador {

    void cadastrarLivro(Livro livro);
    void excluirLivro(String isbn);
    void gerarRelatorioEmprestimos();
}
