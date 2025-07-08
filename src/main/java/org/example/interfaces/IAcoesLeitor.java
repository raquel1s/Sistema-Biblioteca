package org.example.interfaces;

import org.example.dominio.Leitor;

public interface IAcoesLeitor {

    void vizualizarLivrosDisponiveis();
    void solicitarEmprestimo(String isbn, Leitor leitor);
    void devolucao(String isbn, Leitor leitor);
}
