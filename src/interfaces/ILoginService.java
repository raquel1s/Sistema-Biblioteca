package interfaces;

import dominio.Usuario;

public interface ILoginService {

    Usuario login(String email, String senha);
}
