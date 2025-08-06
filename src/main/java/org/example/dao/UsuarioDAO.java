package org.example.dao;

import org.example.dominio.Usuario;
import org.example.interfaces.IUsuarioRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO implements IUsuarioRepository {

    @Override
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, idade) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return null;
    }

    @Override
    public ArrayList<Usuario> listarTodos() {
        return null;
    }
}
