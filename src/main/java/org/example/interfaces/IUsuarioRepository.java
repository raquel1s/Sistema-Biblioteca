package org.example.interfaces;

import org.example.dominio.Usuario;

import java.util.ArrayList;

public interface IUsuarioRepository {

    void salvar(Usuario usuario);
    Usuario buscarPorEmail(String email);
    ArrayList<Usuario> listarTodos();
}
