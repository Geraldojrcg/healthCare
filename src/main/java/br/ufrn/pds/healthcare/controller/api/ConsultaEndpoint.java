package br.ufrn.pds.healthcare.controller.api;

import br.ufrn.pds.healthcare.service.interfaces.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/consulta")
public class ConsultaEndpoint {

    private final ConsultaService consultaService;

    @Autowired
    public ConsultaEndpoint(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping("getMarcadas")
    public ResponseEntity<?> getMarcadas() {
        return new ResponseEntity<>(consultaService.buscarMarcadas(), HttpStatus.OK);
    }
}
