package servicos;

import dominio.Emprestimo;
import dominio.Leitor;
import dominio.Livro;
import dominio.Usuario;
import interfaces.IAcoesAdministrador;
import interfaces.ILivroRepository;
import interfaces.IUsuarioRepository;

import java.util.ArrayList;

public class CadastroLivroService implements IAcoesAdministrador {

    private ILivroRepository livroRepository;
    private IUsuarioRepository usuarioRepository;

    public CadastroLivroService(ILivroRepository livroRepository, IUsuarioRepository usuarioRepository) {
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void cadastrarLivro(Livro livro) {
        livroRepository.salvar(livro);
    }

    @Override
    public void excluirLivro(String isbn) {
        livroRepository.remover(isbn);
    }

    @Override
    public void gerarRelatorioEmprestimos() {
        int contador = 0;

        System.out.println("Livros Emprestados: ");
        for(Usuario u : usuarioRepository.listarTodos()) {
            if(u instanceof Leitor leitor){
                for(Emprestimo emprestimo : leitor.getEmprestimos()){
                    Livro livro = emprestimo.getLivro();

                    System.out.println("Leitor " + leitor.getNome() +
                            " | Livro: " + livro.getTitulo() +
                            " | Empréstimo: " + emprestimo.getDataEmprestimo() +
                            " | Devolução: " + emprestimo.getDataDevolucao());
                    contador++;
                }
            }
        }

        System.out.println("Empréstimos ativos: " + contador);
    }
}
