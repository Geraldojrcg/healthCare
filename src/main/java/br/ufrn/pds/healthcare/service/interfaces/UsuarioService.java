package br.ufrn.pds.healthcare.service.interfaces;

import br.ufrn.pds.healthcare.model.Usuario;

import java.util.List;

public interface UsuarioService {
    void salvar(Usuario pessoa);

    void atualizar(Usuario pessoa);

    void deletar(Long id);

    Usuario buscarPorId(Long id);

    List<Usuario> buscarTodos();
}
