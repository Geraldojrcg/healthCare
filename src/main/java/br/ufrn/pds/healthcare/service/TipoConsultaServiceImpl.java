package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.exception.BusinessException;
import br.ufrn.pds.healthcare.model.TipoConsulta;
import br.ufrn.pds.healthcare.repository.TipoConsultaRepository;
import br.ufrn.pds.healthcare.service.interfaces.GenericoService;
import br.ufrn.pds.healthcare.service.interfaces.TipoConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoConsultaServiceImpl implements TipoConsultaService {

    private final GenericoService genericoService;
    private final TipoConsultaRepository tipoConsultaRepository;

    @Autowired
    public TipoConsultaServiceImpl(GenericoService genericoService, TipoConsultaRepository tipoConsultaRepository) {
        this.genericoService = genericoService;
        this.tipoConsultaRepository = tipoConsultaRepository;
    }

    @Override
    public TipoConsulta salvar(TipoConsulta tipoConsulta) {
        try {
        	return tipoConsultaRepository.save(tipoConsulta);
        } catch (Exception e) {
        	throw new BusinessException("Erro ao salvar tipo de consulta.");
		}
    }

    @Override
    public void atualizar(TipoConsulta tipoConsulta) {
        genericoService.throwRecursoNaoEncontradoException(tipoConsulta, tipoConsultaRepository, "O tipo de consulta não existe.");
        try {
        	tipoConsultaRepository.save(tipoConsulta);
        } catch (Exception e) {
        	throw new BusinessException("Erro ao atualizar tipo de consulta.");
		}
    }

    @Override
    public void deletar(Long id) {
        genericoService.throwRecursoNaoEncontradoException(id, tipoConsultaRepository, "O tipo de consulta não existe.");
        try {
        	tipoConsultaRepository.deleteById(id);
        } catch (Exception e) {
        	throw new BusinessException("Erro ao deletar tipo de consulta.");
		}
    }

    @Override
    public TipoConsulta buscarPorId(Long id) {
        genericoService.throwRecursoNaoEncontradoException(id, tipoConsultaRepository, "O tipo de consulta não existe.");
        return tipoConsultaRepository.findById(id).get();
    }

    @Override
    public List<TipoConsulta> buscarTodos() {
        return tipoConsultaRepository.findAll();
    }
}
