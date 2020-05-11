package com.toures.balon.carro.modelo;

import com.toures.balon.carro.persistencia.entidad.Carro;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
@Data
public class CarroModelo {
    private String id;
    private String idSesion;
    private String idUsuario;
    private List<ProductoModelo> productos;
    private boolean activo;

    public CarroModelo() {
    }

    public CarroModelo(Carro carro) {
        this.id = carro.getId();
        this.idSesion = carro.getIdSesion();
        this.idUsuario = carro.getIdUsuario();
        if (Objects.nonNull(carro.getProductos()) && !carro.getProductos().isEmpty()) {
            productos = carro.getProductos().stream().map(producto -> new ProductoModelo(producto)).collect(Collectors.toList());
        }
        this.activo = carro.isActivo();
    }

    public Carro toEntity() {
        UUID uuid = UUID.randomUUID();
        Carro carro = new Carro();
        carro.setId(Objects.isNull(this.id)?uuid.toString():this.id);
        carro.setIdSesion(this.idSesion);
        carro.setIdUsuario(this.idUsuario);
        if (Objects.nonNull(this.productos) && !this.productos.isEmpty()) {
            carro.setProductos(this.productos.stream().map(producto -> producto.toEntity()).collect(Collectors.toList()));
        }

        return carro;
    }
}
