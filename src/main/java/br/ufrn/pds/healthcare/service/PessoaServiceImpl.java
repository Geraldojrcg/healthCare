package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.model.Pessoa;
import br.ufrn.pds.healthcare.repository.PessoaRepository;
import br.ufrn.pds.healthcare.service.interfaces.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
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
    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    @Override
    public List<Pessoa> buscarMedicos() {
        // TODO Adiciona filtro no repositório para buscar apenas médicos
        return pessoaRepository.findAll();
    }

    @Override
    public List<Pessoa> buscarPacientes() {
        // TODO Adiciona filtro no repositório para buscar apenas pacientes
        return pessoaRepository.findAll();
    }
}
