package br.ufrn.pds.healthcare.model;

import javax.persistence.Entity;

@Entity
public class Perfil extends EntidadeAbstrata {
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
