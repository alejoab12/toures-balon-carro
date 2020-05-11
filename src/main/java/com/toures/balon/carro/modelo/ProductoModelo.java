package com.toures.balon.carro.modelo;

import com.toures.balon.carro.persistencia.entidad.Producto;
import lombok.Data;

@Data
public class ProductoModelo {
    private String id;
    private String tipo;
    private Integer cantidad;

    public ProductoModelo() {
    }

    public ProductoModelo(Producto producto) {
        this.id = producto.getId();
        this.tipo = producto.getTipo();
        this.cantidad = producto.getCantidad();
    }
    public Producto toEntity(){
        Producto producto=new Producto();
        producto.setId(this.id);
        producto.setCantidad(this.cantidad);
        producto.setTipo(this.tipo);
        return producto;
    }
}
