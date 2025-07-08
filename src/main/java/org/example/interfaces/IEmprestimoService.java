package org.example.interfaces;

import org.example.dominio.Leitor;
import org.example.dominio.Livro;

public interface IEmprestimoService {

    void emprestarLivro(Leitor leitor, Livro livro);
    void devolverLivro(Leitor leitor, Livro livro);
}
