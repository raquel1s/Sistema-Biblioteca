package org.example;

import org.example.dominio.*;
import org.example.interfaces.*;
import org.example.repositorio.LivroRepositoryEmMemoria;
import org.example.repositorio.UsuarioRepositorioEmMemoria;
import org.example.servicos.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static int opcao = 0;
    private static final Scanner sc = new Scanner(System.in);
    private static final IUsuarioRepository usuarioRepo = new UsuarioRepositorioEmMemoria();
    private static final CadastroUsuarioService cadastroUsuario = new CadastroUsuarioService(usuarioRepo);
    private static final ILoginService autenticar = new AutenticacaoService(usuarioRepo);
    private static final ILivroRepository livroRepo = new LivroRepositoryEmMemoria();
    private static final IAcoesAdministrador acoesAdm = new CadastroLivroService(livroRepo, usuarioRepo);
    private static final IEmprestimoService emprestimo = new EmprestimoService(livroRepo);
    private static final IAcoesLeitor acoesLeitor = new LeitorService(livroRepo, emprestimo);


    public static void main(String[] args) {
            opcao = 0;

            do{
                System.out.println("1. Cadastrar");
                System.out.println("2. Entrar");
                System.out.println("3. Sair");
                opcao = sc.nextInt();

                switch (opcao){
                    case 1 -> cadastrarLeitor();
                    case 2 -> {
                        sc.nextLine();
                        login();
                    }
                    case 3 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção Inválida.");
                }
            }while(opcao != 3);
        }

        public static void login(){
            for(int i =0; i<3; i++){
                System.out.println("Digite seu email: ");
                String email = sc.nextLine();

                System.out.println("Digite sua senha: ");
                String senha = sc.nextLine();

                Usuario usuario = autenticar.login(email, senha);

                if(usuario instanceof Leitor){
                    menuLeitor((Leitor) usuario);
                    return;
                }else if(usuario instanceof Administrador){
                    menuAdministrador();
                    return;
                }else{
                    System.out.println("Email ou senha incorretos.");
                }
            }
            System.out.println("Tentativas excedidas.");
        }

        public static void cadastrarLeitor(){
            System.out.println("Digite seu nome: ");
            String nome = sc.next();

            System.out.println("Digite seu email: ");
            String email = sc.next();

            System.out.println("Digite sua senha: ");
            String senha = sc.next();

            System.out.println("Digite sua matricula: ");
            String matricula = sc.next();

            cadastroUsuario.cadastrarLeitor(nome, email, senha, matricula);
        }

        public static void cadastrar(){
            opcao = 0;
            Usuario usuario;

            System.out.println("1. Leitor");
            System.out.println("2. Administrador");
            opcao = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite o nome: ");
            String nome = sc.next();

            System.out.println("Digite o email: ");
            String email = sc.next();

            System.out.println("Digite a senha: ");
            String senha = sc.next();

            switch (opcao){
                case 1 -> {
                    System.out.println("Digite a matricula: ");
                    String matricula = sc.next();

                    cadastroUsuario.cadastrarLeitor(nome, email, senha, matricula);
                }
                case 2 -> {
                    System.out.println("Digite o cargo: ");
                    String cargo = sc.next();

                    cadastroUsuario.cadastrarAdministrador(nome, email, senha, cargo);
                }
                default -> System.out.println("Opção Inválida.");
            }
        }

        public static void menuLeitor(Leitor leitor){
            opcao = 0;

            do{
                System.out.println("1. Ver livros disponíveis");
                System.out.println("2. Solicitar empréstimo");
                System.out.println("3. Consultar meus empréstimos");
                System.out.println("4. Devolver livro");
                System.out.println("4. Sair");
                opcao = sc.nextInt();

                switch (opcao){
                    case 1 -> acoesLeitor.vizualizarLivrosDisponiveis();
                    case 2 -> {
                        sc.nextLine();
                        System.out.println("Digite o ISBN do livro que você deseja emprestar: ");
                        String isbn = sc.nextLine();

                        acoesLeitor.solicitarEmprestimo(isbn, leitor);
                    }
                    case 3 -> {
                        if(!leitor.getEmprestimos().isEmpty()){
                            for(Emprestimo e : leitor.getEmprestimos()){
                                System.out.println(e.getLivro() + "\nData de devolução: " + e.getDataDevolucao());
                            }
                        }else{
                            System.out.println("Você não possui nenhum empréstimo.");
                        }
                    }
                    case 4 -> {
                        System.out.println("Digite o ISBN do livro que você deseja emprestar: ");
                        String isbn = sc.nextLine();

                        acoesLeitor.devolucao(isbn, leitor);
                    }
                    case 5 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção Inválida.");
                }

            }while(opcao != 5);
        }

        public static void menuAdministrador(){
            opcao = 0;

            do{
                System.out.println("1. Cadastrar usuário");
                System.out.println("2. Cadastrar livro");
                System.out.println("3. Remover livro");
                System.out.println("4. Ver relatório de empréstimos");
                System.out.println("5. Sair");
                opcao = sc.nextInt();

                switch(opcao){
                    case 1 -> cadastrar();
                    case 2 -> {
                        sc.nextLine();
                        System.out.println("Digite o Título: ");
                        String titulo = sc.nextLine();

                        System.out.println("Digite o autor: ");
                        String autor = sc.nextLine();

                        System.out.println("Digite o ISBN: ");
                        String isbn = sc.nextLine();

                        Livro livro = new Livro(titulo, autor, isbn);
                        acoesAdm.cadastrarLivro(livro);

                        System.out.println("Livro cadastrado com sucesso.");
                    }
                    case 3 -> {
                        System.out.println("Digite o ISBN do livro que deseja remover: ");
                        String isbn = sc.next();

                        acoesAdm.excluirLivro(isbn);
                    }
                    case 4 -> acoesAdm.gerarRelatorioEmprestimos();
                    case 5 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }

            }while(opcao != 5);

    }
}