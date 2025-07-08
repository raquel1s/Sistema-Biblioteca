package org.example.servicos;

import org.example.dominio.Usuario;
import org.example.interfaces.ILoginService;
import org.example.interfaces.IUsuarioRepository;

public class AutenticacaoService implements ILoginService {

    private IUsuarioRepository usuarioRepository;

    public AutenticacaoService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario login(String email, String senha) {
        Usuario usuario = usuarioRepository.buscarPorEmail(email);
        if(usuario != null && usuario.getSenha().equals(senha)){
            return usuario;
        }
        return null;
    }

}
