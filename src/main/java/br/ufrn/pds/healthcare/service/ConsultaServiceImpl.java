package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.model.Consulta;
import br.ufrn.pds.healthcare.model.ConsultaStatus;
import br.ufrn.pds.healthcare.repository.ConsultaRepository;
import br.ufrn.pds.healthcare.service.interfaces.ConsultaService;
import br.ufrn.pds.healthcare.service.interfaces.GenericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    private final GenericoService genericoService;
    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaServiceImpl(GenericoService genericoService, ConsultaRepository consultaRepository) {
        this.genericoService = genericoService;
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Consulta salvar(Consulta consulta) {
        consulta.setStatus(ConsultaStatus.MARCADA);
        return consultaRepository.save(consulta);
    }

    @Override
    public void atualizar(Consulta consulta) {
        genericoService.throwRecursoNaoEncontradoException(consulta, consultaRepository, "Consulta não encontrada.");
        consultaRepository.save(consulta);
    }

    @Override
    public void deletar(Long id) {
        genericoService.throwRecursoNaoEncontradoException(id, consultaRepository, "Consulta não encontrada.");
        consultaRepository.deleteById(id);
    }

    @Override
    public Consulta buscarPorId(Long id) {
        genericoService.throwRecursoNaoEncontradoException(id, consultaRepository, "Consulta não encontrada.");
        return consultaRepository.findById(id).get();
    }

    @Override
    public List<Consulta> buscarTodos() {
        return consultaRepository.findAll();
    }

    @Override
    public List<Consulta> buscarMarcadas() {
        return consultaRepository.findByStatus(ConsultaStatus.MARCADA);
    }

    @Override
    public List<Consulta> buscarRealizadasHoje() {
        return consultaRepository.findByStatusAndHorario(ConsultaStatus.ATENDIDA, LocalDateTime.now());
    }

    @Override
    public void atualizarStatusConsultasAtrasadas() {
        consultaRepository.atualizarStatusConsultasAtrasadas(LocalDateTime.now());
    }
}
