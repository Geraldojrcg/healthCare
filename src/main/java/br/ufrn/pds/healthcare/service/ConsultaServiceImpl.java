package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.model.Consulta;
import br.ufrn.pds.healthcare.repository.ConsultaRepository;
import br.ufrn.pds.healthcare.service.interfaces.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Consulta salvar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public void atualizar(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    @Override
    public void deletar(Long id) {
        consultaRepository.deleteById(id);
    }

    @Override
    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id).get();
    }

    @Override
    public List<Consulta> buscarTodos() {
        return consultaRepository.findAll();
    }
}
