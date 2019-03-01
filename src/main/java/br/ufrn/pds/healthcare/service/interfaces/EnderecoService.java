package br.ufrn.pds.healthcare.service.interfaces;

import br.ufrn.pds.healthcare.model.Endereco;
import br.ufrn.pds.healthcare.model.Pessoa;

import java.util.List;

public interface EnderecoService {
    void salvar(Endereco pessoa);

    void atualizar(Endereco pessoa);

    void deletar(Long id);

    Endereco buscarPorId(Long id);

    List<Endereco> buscarTodos();
}
