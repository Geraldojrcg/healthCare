package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.model.Perfil;
import br.ufrn.pds.healthcare.model.Pessoa;
import br.ufrn.pds.healthcare.repository.PessoaRepository;
import br.ufrn.pds.healthcare.service.interfaces.PerfilService;
import br.ufrn.pds.healthcare.service.interfaces.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PerfilService perfilService;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository, PerfilService perfilService) {
        this.pessoaRepository = pessoaRepository;
        this.perfilService = perfilService;
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    @Override
    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public Pessoa buscarPorId(Long id) {
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
