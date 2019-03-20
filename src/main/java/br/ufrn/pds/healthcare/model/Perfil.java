package br.ufrn.pds.healthcare.model;

import javax.persistence.Entity;

@Entity
public class Perfil extends EntidadeAbstrata {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
