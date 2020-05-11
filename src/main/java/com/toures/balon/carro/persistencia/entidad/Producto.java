package com.toures.balon.carro.persistencia.entidad;

import lombok.Data;

@Data
public class Producto {
    private String id;
    private String tipo;
    private Integer cantidad;
}
