package br.ufrn.pds.healthcare.controller;

import br.ufrn.pds.healthcare.model.Usuario;
import br.ufrn.pds.healthcare.service.interfaces.PerfilService;
import br.ufrn.pds.healthcare.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("dashboard/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PerfilService perfilService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, PerfilService perfilService) {
        this.usuarioService = usuarioService;
        this.perfilService = perfilService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.buscarTodos());
        return "dashboard/usuario/listar";
    }

    @GetMapping("{id}/editar")
    public String editar(Model model, @PathVariable Long id) {
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        Usuario teste = usuarioService.buscarPorId(id);
        model.addAttribute("perfis", perfilService.buscarTodos());
        return "dashboard/usuario/editar";
    }

    @PostMapping("{id}/editar")
    public String atualizar(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "dashboard/usuario/editar";
        }
        usuarioService.atualizar(usuario);
        return "redirect:/dashboard/usuario";
    }

    @GetMapping("{id}/deletar")
    public String deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return "redirect:/dashboard/usuario";
    }
}
