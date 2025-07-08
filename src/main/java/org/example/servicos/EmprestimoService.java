package org.example.servicos;

import org.example.dominio.Emprestimo;
import org.example.dominio.Leitor;
import org.example.dominio.Livro;
import org.example.interfaces.IEmprestimoService;
import org.example.interfaces.ILivroRepository;

import java.time.LocalDate;

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
        LocalDate dataPrevista = dataEmprestimo.plusDays(15);
        Emprestimo emprestimo = new Emprestimo(livro, leitor, dataEmprestimo, dataPrevista);

        leitor.getEmprestimos().add(emprestimo);
        livro.setDisponivel(false);

        System.out.println("Livro emprestado com sucesso.");
    }

    @Override
    public void devolverLivro(Leitor leitor, Livro livro) {
        Emprestimo emprestimoEncontrado = null;

        for(Emprestimo e : leitor.getEmprestimos()){
            if(e.getLivro().equals(livro)){
                emprestimoEncontrado = e;
                break;
            }
        }

        if(emprestimoEncontrado != null){
            livro.setDisponivel(true);
            leitor.getEmprestimos().remove(emprestimoEncontrado);
            System.out.println("Livro devolvido com sucesso.");
        }else{
            System.out.println("Este livro não foi emprestado.");
        }
    }
}
