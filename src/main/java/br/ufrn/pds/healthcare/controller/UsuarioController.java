package br.ufrn.pds.healthcare.controller;

import br.ufrn.pds.healthcare.model.Usuario;
import br.ufrn.pds.healthcare.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("dashboard/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.buscarTodos());
        return "usuario/listar";
    }

    @GetMapping("{id}/editar")
    public String editar(Model model, @PathVariable Long id) {
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        return "usuario/editar";
    }

    @PostMapping("{id}/editar")
    public String atualizar(Model model, @PathVariable Long id, @Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "usuario/editar";
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
