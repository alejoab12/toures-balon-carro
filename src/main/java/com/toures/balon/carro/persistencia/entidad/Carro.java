package com.toures.balon.carro.persistencia.entidad;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash("carro")
@Data
public class Carro {
    @Id
    private String id;
    private String idSesion;
    private String idUsuario;
    private List<Producto> productos;
    private boolean activo;

    public Carro() {
    }

    public Carro(String id) {
        this.id = id;
    }
}

