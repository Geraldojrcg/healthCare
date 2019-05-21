package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.exception.BusinessException;
import br.ufrn.pds.healthcare.model.Perfil;
import br.ufrn.pds.healthcare.model.Pessoa;
import br.ufrn.pds.healthcare.repository.PessoaRepository;
import br.ufrn.pds.healthcare.service.interfaces.GenericoService;
import br.ufrn.pds.healthcare.service.interfaces.PerfilService;
import br.ufrn.pds.healthcare.service.interfaces.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final GenericoService genericoService;
    private final PessoaRepository pessoaRepository;
    private final PerfilService perfilService;

    @Autowired
    public PessoaServiceImpl(GenericoService genericoService, PessoaRepository pessoaRepository, PerfilService perfilService) {
        this.genericoService = genericoService;
        this.pessoaRepository = pessoaRepository;
        this.perfilService = perfilService;
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        if(pessoa.getPerfil() == null) {
            pessoa.setPerfil(perfilService.buscarPorNome("PACIENTE"));
        }
        try {
        	return pessoaRepository.save(pessoa);
        } catch (Exception e) {
        	throw new BusinessException("Erro ao salvar pessoa.");
		}
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        genericoService.throwRecursoNaoEncontradoException(pessoa, pessoaRepository, "Pessoa não encontrada.");
        try {
        	pessoaRepository.save(pessoa);
        } catch (Exception e) {
        	throw new BusinessException("Erro ao atualizar pessoa.");
		}
    }

    @Override
    public void deletar(Long id) {
        genericoService.throwRecursoNaoEncontradoException(id, pessoaRepository, "Pessoa não encontrada.");
        try {
        	pessoaRepository.deleteById(id);
        } catch (Exception e) {
        	throw new BusinessException("Erro ao remover pessoa");
		}
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        genericoService.throwRecursoNaoEncontradoException(id, pessoaRepository, "Pessoa não encontrada.");
        return pessoaRepository.findById(id).get();
    }

    @Override
    public Pessoa buscarPorCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    @Override
    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    @Override
    public List<Pessoa> buscarMedicos() {
        Perfil medico = perfilService.buscarPorNome("MEDICO");
        return pessoaRepository.findByPerfil(medico);
    }

    @Override
    public List<Pessoa> buscarPacientes() {
        Perfil paciente = perfilService.buscarPorNome("PACIENTE");
        return pessoaRepository.findByPerfil(paciente);
    }
}
