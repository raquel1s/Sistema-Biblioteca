package org.example.dominio;

public class Administrador extends Usuario{

    private String cargo;

    public Administrador(int id, String nome, String email, String senha, String cargo) {
        super(id, nome, email, senha);
        this.cargo = cargo;
    }

    public Administrador(String nome, String email, String senha, String cargo) {
        super(nome, email, senha);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void apresentar() {
        System.out.println("" +
                "Nome: " + this.getNome() +
                "\nEmail: " + this.getEmail() +
                "\nCargo: " + this.cargo);
    }
}
