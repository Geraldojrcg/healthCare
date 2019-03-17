package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.model.Usuario;
import br.ufrn.pds.healthcare.repository.UsuarioRepository;
import br.ufrn.pds.healthcare.service.interfaces.PerfilService;
import br.ufrn.pds.healthcare.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PerfilService perfilService;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PerfilService perfilService) {
        this.usuarioRepository = usuarioRepository;
        this.perfilService = perfilService;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        usuario.setPerfil(perfilService.buscarPorDescricao("USUARIO"));
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
