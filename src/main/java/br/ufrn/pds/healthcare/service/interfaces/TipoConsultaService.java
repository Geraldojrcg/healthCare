package br.ufrn.pds.healthcare.service.interfaces;

import br.ufrn.pds.healthcare.model.TipoConsulta;

import java.util.List;

public interface TipoConsultaService {
    TipoConsulta salvar(TipoConsulta tipoConsulta);

    void atualizar(TipoConsulta tipoConsulta);

    void deletar(Long id);

    TipoConsulta buscarPorId(Long id);

    List<TipoConsulta> buscarTodos();
}
