package servicos;

import dominio.Leitor;
import dominio.Livro;
import interfaces.IAcoesLeitor;
import interfaces.IEmprestimoService;
import interfaces.ILivroRepository;

public class LeitorService implements IAcoesLeitor {

    private ILivroRepository livroRepo;
    private IEmprestimoService emprestimoService;

    public LeitorService(ILivroRepository livroRepo, IEmprestimoService emprestimoService) {
        this.livroRepo = livroRepo;
        this.emprestimoService = emprestimoService;
    }

    @Override
    public void vizualizarLivrosDisponiveis() {
        for(Livro l : livroRepo.listarTodosLivros()){
            if(l.isDisponivel()){
                System.out.println(l);
            }
        }
    }

    @Override
    public void solicitarEmprestimo(String isbn, Leitor leitor) {
        Livro livro = livroRepo.buscarLivroPorIsbn(isbn);

        emprestimoService.emprestarLivro(leitor, livro);
    }
}
