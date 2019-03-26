package br.ufrn.pds.healthcare.repository;

import br.ufrn.pds.healthcare.model.Perfil;
import br.ufrn.pds.healthcare.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByCpf(String cpf);

    List<Pessoa> findByPerfil(Perfil perfil);
}
