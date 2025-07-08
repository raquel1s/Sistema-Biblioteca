package org.example.repositorio;

import org.example.dominio.Administrador;
import org.example.dominio.Usuario;
import org.example.interfaces.IUsuarioRepository;

import java.util.ArrayList;

public class UsuarioRepositorioEmMemoria implements IUsuarioRepository {

    private ArrayList<Usuario> usuarios;
    private Usuario adm = new Administrador("Raquel da Silva", "adm@gmail.com", "Adm@123", "Bibliotecaria");

    public UsuarioRepositorioEmMemoria() {
        this.usuarios = new ArrayList<>();
        usuarios.add(adm);
    }

    @Override
    public void salvar(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        for(Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Usuario> listarTodos() {
        return usuarios;
    }
}
