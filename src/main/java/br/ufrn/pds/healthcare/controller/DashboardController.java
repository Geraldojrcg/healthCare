package br.ufrn.pds.healthcare.controller;

import br.ufrn.pds.healthcare.service.interfaces.ConsultaService;
import br.ufrn.pds.healthcare.service.interfaces.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard")
public class DashboardController {

    private final PessoaService pessoaService;
    private final ConsultaService consultaService;

    @Autowired
    public DashboardController(PessoaService pessoaService, ConsultaService consultaService) {
        this.pessoaService = pessoaService;
        this.consultaService = consultaService;
    }

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("pacientesCadastrados", pessoaService.buscarPacientes().size());
        model.addAttribute("consultasMarcadas", consultaService.buscarMarcadas().size());
        model.addAttribute("realizadasHoje", consultaService.buscarRealizadasHoje().size());
        return "dashboard/dashboard";
    }
}
