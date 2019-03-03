package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.model.Endereco;
import br.ufrn.pds.healthcare.repository.EnderecoRepository;
import br.ufrn.pds.healthcare.service.interfaces.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public void atualizar(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    @Override
    public void deletar(Long id) {
        enderecoRepository.deleteById(id);
    }

    @Override
    public Endereco buscarPorId(Long id) {
        return enderecoRepository.findById(id).get();
    }

    @Override
    public List<Endereco> buscarTodos() {
        return enderecoRepository.findAll();
    }
}
