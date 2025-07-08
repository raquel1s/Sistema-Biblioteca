package org.example.interfaces;

import org.example.dominio.Usuario;

public interface ILoginService {

    Usuario login(String email, String senha);
}
