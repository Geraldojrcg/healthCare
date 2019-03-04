package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.model.TipoConsulta;
import br.ufrn.pds.healthcare.repository.TipoConsultaRepository;
import br.ufrn.pds.healthcare.service.interfaces.TipoConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoConsultaServiceImpl implements TipoConsultaService {

    private final TipoConsultaRepository tipoConsultaRepository;

    @Autowired
    public TipoConsultaServiceImpl(TipoConsultaRepository tipoConsultaRepository) {
        this.tipoConsultaRepository = tipoConsultaRepository;
    }

    @Override
    public TipoConsulta salvar(TipoConsulta tipoConsulta) {
        return tipoConsultaRepository.save(tipoConsulta);
    }

    @Override
    public void atualizar(TipoConsulta tipoConsulta) {
        tipoConsultaRepository.save(tipoConsulta);
    }

    @Override
    public void deletar(Long id) {
        tipoConsultaRepository.deleteById(id);
    }

    @Override
    public TipoConsulta buscarPorId(Long id) {
        return tipoConsultaRepository.findById(id).get();
    }

    @Override
    public List<TipoConsulta> buscarTodos() {
        return tipoConsultaRepository.findAll();
    }
}
