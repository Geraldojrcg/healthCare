package br.ufrn.pds.healthcare.repository;

import br.ufrn.pds.healthcare.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByCpf(String cpf);
}
