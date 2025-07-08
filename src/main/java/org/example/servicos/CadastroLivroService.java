package org.example.servicos;

import org.example.dominio.Emprestimo;
import org.example.dominio.Leitor;
import org.example.dominio.Livro;
import org.example.dominio.Usuario;
import org.example.interfaces.IAcoesAdministrador;
import org.example.interfaces.ILivroRepository;
import org.example.interfaces.IUsuarioRepository;

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
        for(Livro l : livroRepository.listarTodosLivros()){
            if(l.getIsbn().equals(isbn)){
                if(l.isDisponivel()){
                    livroRepository.remover(isbn);
                    System.out.println("Livro removido com sucesso.");
                    return;
                }else{
                    System.out.println("Livro não pode ser removido pois está emprestado.");
                    return;
                }
            }
        }

        System.out.println("Erro ao excluir livro. Verifique o ISBN do livro.");
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
