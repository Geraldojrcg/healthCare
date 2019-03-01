package br.ufrn.pds.healthcare.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;

@Entity
public class Endereco extends EntidadeAbstrata {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;

    @Length(min = 8, max = 8)
    private String cep;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
