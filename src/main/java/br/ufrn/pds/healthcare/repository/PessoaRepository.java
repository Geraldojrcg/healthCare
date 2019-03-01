package br.ufrn.pds.healthcare.repository;

import br.ufrn.pds.healthcare.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {}
