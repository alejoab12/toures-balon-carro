package com.toures.balon.carro.persistencia.repositorio;

import com.toures.balon.carro.persistencia.entidad.Carro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarroRepositorio extends CrudRepository<Carro, String> {
    public List<Carro> findByIdUsuario(String idUsuario);

    public boolean existsCarroByIdUsuario(String idUsuario);
}
