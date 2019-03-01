package br.ufrn.pds.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Usuario extends EntidadeAbstrata {
    @Email
    @NotEmpty(message = "O campo email é obrigatório.")
    private String email;

    @NotEmpty(message = "O campo senha é obrigatório")
    private String senha;

    @OneToOne
    private Pessoa pessoa;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
