package br.ufrn.pds.healthcare.controller;

import br.ufrn.pds.healthcare.model.Pessoa;
import br.ufrn.pds.healthcare.service.interfaces.PessoaService;
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
@RequestMapping("dashboard/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pessoas", pessoaService.buscarTodos());
        return "pessoa/listar";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Model model, Pessoa pessoa) {
        model.addAttribute("pessoa", pessoa);
        return "pessoa/cadastrar";
    }

    @GetMapping("{id}/editar")
    public String editar(Model model, @PathVariable Long id) {
        model.addAttribute("pessoa", pessoaService.buscarPorId(id));
        return "pessoa/editar";
    }

    @PostMapping
    public String salvar(@Valid Pessoa pessoa, BindingResult result) {
        if(result.hasErrors()) {
            return "pessoa/cadastrar";
        }
        pessoaService.salvar(pessoa);
        return "redirect:/dashboard/pessoa";
    }

    @PostMapping("{id}/editar")
    public String atualizar(Model model, @PathVariable Long id, @Valid Pessoa pessoa, BindingResult result) {
        if(result.hasErrors()) {
            return "pessoa/editar";
        }
        pessoaService.atualizar(pessoa);
        return "redirect:/dashboard/pessoa";
    }

    @GetMapping("{id}/deletar")
    public String deletar(@PathVariable Long id) {
        pessoaService.deletar(id);
        return "redirect:/dashboard/pessoa";
    }
}
