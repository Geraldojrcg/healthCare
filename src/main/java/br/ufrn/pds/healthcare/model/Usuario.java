package br.ufrn.pds.healthcare.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Usuario extends EntidadeAbstrata {
    @CPF
    @NotEmpty
    @Length(min = 11, max = 11, message = "O campo cpf deve ter 11 dígitos")
    private String cpf;

    @Email
    @NotEmpty(message = "O campo email é obrigatório.")
    private String email;

    @NotEmpty(message = "O campo senha é obrigatório")
    private String senha;

    @OneToOne
    private Pessoa pessoa;

    @ManyToOne(optional = false)
    private Perfil perfil;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

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

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
