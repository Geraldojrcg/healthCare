package br.ufrn.pds.healthcare.model;

public enum ConsultaStatus {

    MARCADA("Marcada"),
    REMARCADA("Remarcada"),
    CANCELADA("Cancelada"),
    EM_ATENDIMENTO("Em atendimento"),
    ATENDIDA("Atendida"),
    ATRASADA("Atrasada");

    private final String nomeExibicao;

    ConsultaStatus(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }
}
