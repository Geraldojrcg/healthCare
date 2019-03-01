package br.ufrn.pds.healthcare.repository;

import br.ufrn.pds.healthcare.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {}
