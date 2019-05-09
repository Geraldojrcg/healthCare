package br.ufrn.pds.healthcare.exception;

public class Erro500Exception extends RuntimeException {
    public Erro500Exception(String mensagem) {
        super(mensagem);
    }
}
