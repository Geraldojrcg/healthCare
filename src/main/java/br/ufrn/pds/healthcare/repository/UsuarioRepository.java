package br.ufrn.pds.healthcare.repository;

import br.ufrn.pds.healthcare.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
