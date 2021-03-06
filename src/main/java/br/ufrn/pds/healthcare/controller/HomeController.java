package br.ufrn.pds.healthcare.controller;

import br.ufrn.pds.healthcare.model.Usuario;
import br.ufrn.pds.healthcare.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final UsuarioService usuarioService;

    @Autowired
    public HomeController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("registrar")
    public String registrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registrar";
    }

    @PostMapping("registrar")
    public String registrar(@Valid Usuario usuario, BindingResult result) {
        if(result.hasErrors()) {
            return "registrar";
        }
        if(usuarioService.salvar(usuario) == null) {
            FieldError erro = new FieldError("cpf", "pessoa.cpf", "O usuário não tem o cadastro de pessoa, por favor entre em contato com nosso atendente.");
            result.addError(erro);
            return "registrar";
        }
        return "redirect:/login";
    }
}
