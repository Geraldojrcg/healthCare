package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.exception.RecursoNaoEncontradoException;
import br.ufrn.pds.healthcare.model.EntidadeAbstrata;
import br.ufrn.pds.healthcare.service.interfaces.GenericoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenericoServiceImpl implements GenericoService {
    public <T extends EntidadeAbstrata, ID extends Long> void throwRecursoNaoEncontradoException(T t, JpaRepository<T, Long> repository, String mensagem) {
        if(t == null || t.getId() == null || !repository.findById(t.getId()).isPresent()) {
            throw new RecursoNaoEncontradoException(mensagem);
        }
    }

    public <T extends EntidadeAbstrata, ID extends Long> void throwRecursoNaoEncontradoException(Long id, JpaRepository<T, Long> repository, String mensagem) {
        if(id == 0 || !repository.findById(id).isPresent()) {
            throw new RecursoNaoEncontradoException(mensagem);
        }
    }
}
