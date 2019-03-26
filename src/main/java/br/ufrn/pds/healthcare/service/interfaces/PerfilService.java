package br.ufrn.pds.healthcare.service.interfaces;

import br.ufrn.pds.healthcare.model.Perfil;

import java.util.List;

public interface PerfilService {
    List<Perfil> buscarTodos();

    Perfil buscarPorNome(String nome);
}
