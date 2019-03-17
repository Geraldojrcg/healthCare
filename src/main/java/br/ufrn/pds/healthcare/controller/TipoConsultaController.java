package br.ufrn.pds.healthcare.controller;

import br.ufrn.pds.healthcare.model.TipoConsulta;
import br.ufrn.pds.healthcare.service.interfaces.TipoConsultaService;
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
@RequestMapping("dashboard/tipoConsulta")
public class TipoConsultaController {

    private final TipoConsultaService tipoConsultaService;

    @Autowired
    public TipoConsultaController(TipoConsultaService tipoConsultaService) {
        this.tipoConsultaService = tipoConsultaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tiposConsulta", tipoConsultaService.buscarTodos());
        return "tipoConsulta/listar";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Model model, TipoConsulta tipoConsulta) {
        model.addAttribute("tipoConsulta", tipoConsulta);
        return "tipoConsulta/cadastrar";
    }

    @GetMapping("{id}/editar")
    public String editar(Model model, @PathVariable Long id) {
        model.addAttribute("tipoConsulta", tipoConsultaService.buscarPorId(id));
        return "tipoConsulta/editar";
    }

    @PostMapping
    public String salvar(@Valid TipoConsulta tipoConsulta, BindingResult result) {
        if(result.hasErrors()) {
            return "tipoConsulta/cadastrar";
        }
        tipoConsultaService.salvar(tipoConsulta);
        return "redirect:/dashboard/tipoConsulta";
    }

    @PostMapping("{id}/editar")
    public String atualizar(Model model, @PathVariable Long id, @Valid TipoConsulta tipoConsulta, BindingResult result) {
        if(result.hasErrors()) {
            return "tipoConsulta/editar";
        }
        tipoConsultaService.atualizar(tipoConsulta);
        return "redirect:/dashboard/tipoConsulta";
    }

    @GetMapping("{id}/deletar")
    public String deletar(@PathVariable Long id) {
        tipoConsultaService.deletar(id);
        return "redirect:/dashboard/tipoConsulta";
    }
}
