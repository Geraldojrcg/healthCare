package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.model.Perfil;
import br.ufrn.pds.healthcare.repository.PerfilRepository;
import br.ufrn.pds.healthcare.service.interfaces.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl implements PerfilService {

    private final PerfilRepository perfilRepository;

    @Autowired
    public PerfilServiceImpl(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Override
    public Perfil buscarPorDescricao(String descricao) {
        return perfilRepository.findByDescricao(descricao);
    }
}
