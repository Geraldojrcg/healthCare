package br.ufrn.pds.healthcare.controller;

import br.ufrn.pds.healthcare.exception.BusinessException;
import br.ufrn.pds.healthcare.exception.RecursoNaoEncontradoException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public String handleRecursoNaoEncontradoException(RecursoNaoEncontradoException rneException) {
        return "erro/404";
    }
    
    @ExceptionHandler(BusinessException.class)
    public String handleErro500Exception(BusinessException businessException) {
        return "erro/500";
    }
}
