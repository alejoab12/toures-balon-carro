package com.toures.balon.carro.excepcion;

import lombok.Getter;

@Getter
public class RestExcepcion extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer codeResponse;

    public RestExcepcion(Integer codeResponse, String message) {
        super(message);
        this.codeResponse = codeResponse;
    }
}
