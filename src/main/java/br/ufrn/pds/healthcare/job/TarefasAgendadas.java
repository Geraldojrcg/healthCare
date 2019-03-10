package br.ufrn.pds.healthcare.job;

import br.ufrn.pds.healthcare.service.interfaces.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TarefasAgendadas {

    private final ConsultaService consultaService;

    @Autowired
    public TarefasAgendadas(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @Scheduled(fixedRate = 1000)
    public void atualizarStatusConsultasAtrasadas() {
        consultaService.atualizarStatusConsultasAtrasadas();
    }
}
