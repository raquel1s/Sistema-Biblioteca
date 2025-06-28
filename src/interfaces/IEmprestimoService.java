package interfaces;

import dominio.Leitor;
import dominio.Livro;

import java.util.ArrayList;

public interface IEmprestimoService {

    void emprestarLivro(Leitor leitor, Livro livro);
}
