package servicos;

import dominio.Emprestimo;
import dominio.Leitor;
import dominio.Livro;
import interfaces.IEmprestimoService;
import interfaces.ILivroRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmprestimoService implements IEmprestimoService {

    private ILivroRepository livroRepository;

    public EmprestimoService(ILivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public void emprestarLivro(Leitor leitor, Livro livro) {
        if(leitor.getEmprestimos().size() >= 3){
            System.out.println("Você já possui 3 empréstimos.");
            return;
        }

        if(!livro.isDisponivel()){
            System.out.println("Livro indisponível para empréstimo.");
            return;
        }

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataPrevista = dataEmprestimo.plusDays(30);
        Emprestimo emprestimo = new Emprestimo(livro, leitor, dataEmprestimo, dataPrevista);

        leitor.getEmprestimos().add(emprestimo);
        livro.setDisponivel(false);

        System.out.println("Livro emprestado com sucesso.");
    }
}
