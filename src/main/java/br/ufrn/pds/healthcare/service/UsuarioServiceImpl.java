package br.ufrn.pds.healthcare.service;

import br.ufrn.pds.healthcare.exception.SalvarUsuarioException;
import br.ufrn.pds.healthcare.model.Pessoa;
import br.ufrn.pds.healthcare.model.Usuario;
import br.ufrn.pds.healthcare.repository.UsuarioRepository;
import br.ufrn.pds.healthcare.service.interfaces.PessoaService;
import br.ufrn.pds.healthcare.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PessoaService pessoaService;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PessoaService pessoaService) {
        this.usuarioRepository = usuarioRepository;
        this.pessoaService = pessoaService;
    }

    @Override
    public Usuario salvar(Usuario usuario) throws SalvarUsuarioException {
        if(ehValido(usuario)) {
            usuario.setPessoa(pessoaService.buscarPorCpf(usuario.getPessoa().getCpf()));
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    private boolean ehValido(Usuario usuario) throws SalvarUsuarioException {
        Pessoa pessoa = pessoaService.buscarPorCpf(usuario.getPessoa().getCpf());
        Usuario temp = usuarioRepository.findByEmail(usuario.getEmail());
        return temp == null && pessoa != null && pessoa.getUsuario() == null;
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
