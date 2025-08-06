package org.example.dominio;

import java.util.ArrayList;

public class Leitor extends Usuario{

    private String matricula;
    private ArrayList<Emprestimo> emprestimos;

    public Leitor(int id, String nome, String email, String senha, String matricula) {
        super(id, nome, email, senha);
        this.matricula = matricula;
        this.emprestimos = new ArrayList<>();
    }

    public Leitor(String nome, String email, String senha, String matricula) {
        super(nome, email, senha);
        this.matricula = matricula;
        this.emprestimos = new ArrayList<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public void apresentar() {
        System.out.println("" +
                "Nome: " + this.getNome() +
                "\nMatrícula: " + this.matricula);
        for(Emprestimo e : emprestimos) {
            System.out.println(e);
        }
    }
}
