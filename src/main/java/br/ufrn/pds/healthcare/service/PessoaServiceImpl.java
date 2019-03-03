package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.model.Endereco;
import br.ufrn.pds.healthcare.model.Pessoa;
import br.ufrn.pds.healthcare.repository.PessoaRepository;
import br.ufrn.pds.healthcare.service.interfaces.EnderecoService;
import br.ufrn.pds.healthcare.service.interfaces.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final EnderecoService enderecoService;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository, EnderecoService enderecoService) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoService = enderecoService;
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        Endereco endereco = enderecoService.salvar(pessoa.getEndereco());
        pessoa.setEndereco(endereco);
        return pessoaRepository.save(pessoa);
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        pessoa.getEndereco().setId(buscarPorId(pessoa.getId()).getEndereco().getId());
        enderecoService.atualizar(pessoa.getEndereco());
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
}
