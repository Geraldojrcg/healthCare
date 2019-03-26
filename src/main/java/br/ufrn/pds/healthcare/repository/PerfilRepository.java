package br.ufrn.pds.healthcare.repository;

import br.ufrn.pds.healthcare.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Perfil findByNome(String nome);
}
