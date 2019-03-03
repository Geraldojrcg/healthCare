package br.ufrn.pds.healthcare.service.interfaces;

import br.ufrn.pds.healthcare.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario salvar(Usuario usuario);

    void atualizar(Usuario usuario);

    void deletar(Long id);

    Usuario buscarPorId(Long id);

    List<Usuario> buscarTodos();
}
