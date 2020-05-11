package com.toures.balon.carro.servicio.imp;

import com.toures.balon.carro.excepcion.RestExcepcion;
import com.toures.balon.carro.modelo.CarroModelo;
import com.toures.balon.carro.persistencia.entidad.Carro;
import com.toures.balon.carro.persistencia.repositorio.CarroRepositorio;
import com.toures.balon.carro.servicio.CarroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroServicioImp implements CarroServicio {
    @Autowired
    private CarroRepositorio carroRepositorio;

    @Override
    public List<CarroModelo> buscarPorIdUsuario(String idUsuario) {
        if (!carroRepositorio.existsCarroByIdUsuario(idUsuario)) {
            throw new RestExcepcion(404,"No hay carros con el idUsuario:".concat(idUsuario));
        }
        return carroRepositorio.findByIdUsuario(idUsuario).stream().map(carro -> new CarroModelo(carro)).collect(Collectors.toList());
    }

    @Override
    public CarroModelo buscarPorId(String id) {
        Optional<Carro> optionalCarro = carroRepositorio.findById(id);
        if (!optionalCarro.isPresent()) {
            throw new RestExcepcion(404, "Carro no encontrado");
        }
        return new CarroModelo(optionalCarro.get());
    }

    @Override
    public CarroModelo crearCarro(CarroModelo carroModelo) {
        return new CarroModelo(carroRepositorio.save(carroModelo.toEntity()));
    }

    @Override
    public void eliminar(String id) {
        if (!carroRepositorio.existsById(id)) {
            throw new RestExcepcion(404, "Carro no encontrado");
        }
        carroRepositorio.delete(new Carro(id));
    }
}
