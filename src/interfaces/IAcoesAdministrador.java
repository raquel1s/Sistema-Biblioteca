package interfaces;

import dominio.Livro;

public interface IAcoesAdministrador {

    void cadastrarLivro(Livro livro);
    void excluirLivro(String isbn);
    void gerarRelatorioEmprestimos();
}
