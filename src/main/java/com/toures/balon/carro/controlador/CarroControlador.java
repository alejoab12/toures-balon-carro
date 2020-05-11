package com.toures.balon.carro.controlador;

import com.toures.balon.carro.modelo.CarroModelo;
import com.toures.balon.carro.servicio.CarroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroControlador {
    @Autowired
    private CarroServicio carroServicio;

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<CarroModelo> crearCarro(@RequestBody CarroModelo carro) {
        return ResponseEntity.ok(carroServicio.crearCarro(carro));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<CarroModelo> consultarPorid(@RequestParam String id) {

        return ResponseEntity.ok(carroServicio.buscarPorId(id));
    }

    @GetMapping(value = "/usuario", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<CarroModelo>> consultarPorUsuario(@RequestParam String idUsuario) {
        return ResponseEntity.ok(carroServicio.buscarPorIdUsuario(idUsuario));
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(@RequestParam String id) {
        carroServicio.eliminar(id);
        return ResponseEntity.ok().build();
    }

}
