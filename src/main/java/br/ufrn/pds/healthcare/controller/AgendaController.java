package br.ufrn.pds.healthcare.controller;

import br.ufrn.pds.healthcare.service.interfaces.ConsultaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.ufrn.pds.healthcare.service.interfaces.ConsultaService;

@Controller
@RequestMapping("dashboard/agenda")
public class AgendaController {
	
	private final ConsultaService consultaService;
	
	public AgendaController(ConsultaService consultaService) {
		// TODO Auto-generated constructor stub
		 this.consultaService = consultaService;
	}
	
    @GetMapping
    public String agenda(Model model) {
    	model.addAttribute("consultasMarcadas", consultaService.buscarMarcadas());
        return "agenda/agenda";
    }
}
