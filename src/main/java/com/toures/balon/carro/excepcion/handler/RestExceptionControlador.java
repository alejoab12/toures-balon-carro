package com.toures.balon.carro.excepcion.handler;


import com.toures.balon.carro.excepcion.RestExcepcion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionControlador {
    @ExceptionHandler(value = RestExcepcion.class)
    public ResponseEntity<Object> exception(RestExcepcion exception) {
        return ResponseEntity.status(exception.getCodeResponse().intValue()).body(exception.getMessage());
    }
}

