package br.ufrn.pds.healthcare.service.interfaces;

import br.ufrn.pds.healthcare.model.Pessoa;

import java.util.List;

public interface PessoaService {
    Pessoa salvar(Pessoa pessoa);

    void atualizar(Pessoa pessoa);

    void deletar(Long id);

    Pessoa buscarPorId(Long id);

    Pessoa buscarPorCpf(String cpf);

    List<Pessoa> buscarTodos();

    List<Pessoa> buscarMedicos();

    List<Pessoa> buscarPacientes();
}
