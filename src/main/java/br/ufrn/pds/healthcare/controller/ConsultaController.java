package br.ufrn.pds.healthcare.controller;

import br.ufrn.pds.healthcare.model.Consulta;
import br.ufrn.pds.healthcare.service.interfaces.ConsultaService;
import br.ufrn.pds.healthcare.service.interfaces.PessoaService;
import br.ufrn.pds.healthcare.service.interfaces.TipoConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ConsultaController {

    private final ConsultaService consultaService;
    private final TipoConsultaService tipoConsultaService;
    private final PessoaService pessoaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService, TipoConsultaService tipoConsultaService, PessoaService pessoaService) {
        this.consultaService = consultaService;
        this.tipoConsultaService = tipoConsultaService;
        this.pessoaService = pessoaService;
    }

    @GetMapping("consulta")
    public String listar(Model model) {
        model.addAttribute("consultas", consultaService.buscarTodos());
        return "consulta/listar";
    }

    @GetMapping("consulta/cadastrar")
    public String cadastrar(Model model, Consulta consulta) {
        model.addAttribute("consulta", consulta);
        model.addAttribute("tiposConsulta", tipoConsultaService.buscarTodos());
        model.addAttribute("pacientes", pessoaService.buscarPacientes());
        model.addAttribute("medicos", pessoaService.buscarMedicos());
        return "consulta/cadastrar";
    }

    @GetMapping("consulta/{id}/editar")
    public String editar(Model model, @PathVariable Long id) {
        model.addAttribute("consulta", consultaService.buscarPorId(id));
        model.addAttribute("tiposConsulta", tipoConsultaService.buscarTodos());
        model.addAttribute("pacientes", pessoaService.buscarPacientes());
        model.addAttribute("medicos", pessoaService.buscarMedicos());
        return "consulta/editar";
    }

    @PostMapping("consulta")
    public String salvar(@Valid Consulta consulta, BindingResult result) {
        if(result.hasErrors()) {
            return "consulta/cadastrar";
        }
        consultaService.salvar(consulta);
        return "redirect:/consulta";
    }

    @PostMapping("consulta/{id}/editar")
    public String atualizar(Model model, @PathVariable Long id, @Valid Consulta consulta, BindingResult result) {
        if(result.hasErrors()) {
            return "consulta/editar";
        }
        consultaService.atualizar(consulta);
        return "redirect:/consulta";
    }

    @GetMapping("/consulta/{id}/deletar")
    public String deletar(@PathVariable Long id) {
        consultaService.deletar(id);
        return "redirect:/consulta";
    }
}
