package br.ufrn.pds.healthcare.controller;

import br.ufrn.pds.healthcare.model.Pessoa;
import br.ufrn.pds.healthcare.service.interfaces.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("pessoa/cadastrar")
    public String cadastrar(Model model, Pessoa pessoa) {
        model.addAttribute("pessoa", pessoa);
        return "pessoa/cadastrar";
    }

    @PostMapping("pessoa")
    public String salvar(@Valid Pessoa pessoa) {
        pessoaService.salvar(pessoa);
        return "redirect:/pessoa";
    }

    @GetMapping("pessoa")
    public String listar(Model model) {
        model.addAttribute("pessoas", pessoaService.buscarTodos());
        return "pessoa/listar";
    }
}
