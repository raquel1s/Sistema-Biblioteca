package org.example.servicos;

import org.example.dominio.Administrador;
import org.example.dominio.Leitor;
import org.example.dominio.Usuario;
import org.example.interfaces.IUsuarioRepository;

public class CadastroUsuarioService {

    private final IUsuarioRepository usuarioRepo;

    public CadastroUsuarioService(IUsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public void cadastrarLeitor(String nome, String email, String senha, String matricula) {
        Usuario leitor = new Leitor(nome, email, senha, matricula);
        usuarioRepo.salvar(leitor);
        System.out.println("Leitor cadastrado com sucesso.");
    }

    public void cadastrarAdministrador(String nome, String email, String senha, String cargo) {
        Usuario admin = new Administrador(nome, email, senha, cargo);
        usuarioRepo.salvar(admin);
        System.out.println("Administrador cadastrado com sucesso.");
    }
}
