package repositorio;

import dominio.Usuario;
import interfaces.IUsuarioRepository;

import java.util.ArrayList;

public class UsuarioRepositorioEmMemoria implements IUsuarioRepository {

    private ArrayList<Usuario> usuarios;

    public UsuarioRepositorioEmMemoria() {
        this.usuarios = new ArrayList<>();
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
