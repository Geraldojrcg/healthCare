package br.ufrn.pds.healthcare.service.interfaces;

import br.ufrn.pds.healthcare.model.Perfil;

public interface PerfilService {
    Perfil buscarPorDescricao(String descricao);
}
