package br.ufrn.pds.healthcare.service.interfaces;

import br.ufrn.pds.healthcare.model.Consulta;

import java.util.List;

public interface ConsultaService {
    Consulta salvar(Consulta consulta);

    void atualizar(Consulta consulta);

    void deletar(Long id);

    Consulta buscarPorId(Long id);

    List<Consulta> buscarTodos();
}
