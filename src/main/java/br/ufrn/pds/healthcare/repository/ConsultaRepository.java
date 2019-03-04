package br.ufrn.pds.healthcare.repository;

import br.ufrn.pds.healthcare.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {}
