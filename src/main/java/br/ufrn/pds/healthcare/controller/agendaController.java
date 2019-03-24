package br.ufrn.pds.healthcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class agendaController {

    @RequestMapping("agenda")
    public String agenda() {
        return "agenda/agenda";
    }

}
