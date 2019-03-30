package br.ufrn.pds.healthcare.service.interfaces;

import br.ufrn.pds.healthcare.model.EntidadeAbstrata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericoService {
    public <T extends EntidadeAbstrata, ID extends Long> void throwRecursoNaoEncontradoException(T t, JpaRepository<T, Long> repository, String mensagem);

    public <T extends EntidadeAbstrata, ID extends Long> void throwRecursoNaoEncontradoException(Long id, JpaRepository<T, Long> repository, String mensagem);
}
