package com.toures.balon.carro.servicio;

import com.toures.balon.carro.modelo.CarroModelo;

import java.util.List;

public interface CarroServicio {

    List<CarroModelo> buscarPorIdUsuario(String idUsuario);

    CarroModelo buscarPorId(String id);

    CarroModelo crearCarro(CarroModelo carroModelo);

    void eliminar(String id);
}
