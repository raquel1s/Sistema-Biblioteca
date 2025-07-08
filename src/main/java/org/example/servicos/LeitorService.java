package org.example.servicos;

import org.example.dominio.Leitor;
import org.example.dominio.Livro;
import org.example.interfaces.IAcoesLeitor;
import org.example.interfaces.IEmprestimoService;
import org.example.interfaces.ILivroRepository;

public class LeitorService implements IAcoesLeitor {

    private ILivroRepository livroRepo;
    private IEmprestimoService emprestimoService;

    public LeitorService(ILivroRepository livroRepo, IEmprestimoService emprestimoService) {
        this.livroRepo = livroRepo;
        this.emprestimoService = emprestimoService;
    }

    @Override
    public void vizualizarLivrosDisponiveis() {
        if(livroRepo.listarTodosLivros().isEmpty()) {
            System.out.println("Nenhum livro disponível.");
            return;
        }

        boolean livrosEncontrados = false;
        for(Livro l : livroRepo.listarTodosLivros()){
            if(l.isDisponivel()){
                System.out.println(l);
                livrosEncontrados = true;
            }
        }

        if(!livrosEncontrados){
            System.out.println("Todos os livros estão emprestados no momento.");
        }
    }

    @Override
    public void solicitarEmprestimo(String isbn, Leitor leitor) {
        Livro livro = livroRepo.buscarLivroPorIsbn(isbn);

        if(livro != null){
            emprestimoService.emprestarLivro(leitor, livro);
        }else{
            System.out.println("Nenhum livro encontrado.");
        }
    }

    @Override
    public void devolucao(String isbn, Leitor leitor) {
        Livro livro = livroRepo.buscarLivroPorIsbn(isbn);

        if(livro != null){
            emprestimoService.devolverLivro(leitor, livro);
        }else{
            System.out.println("Nenhum livro encontrado. Verifique o ISBN do livro.");
        }
    }
}
