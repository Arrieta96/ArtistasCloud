package com.artistas.artistaswebapp.controlador;

import com.artistas.artistaswebapp.modelo.Servicio;
import com.artistas.artistaswebapp.servicio.ServicioServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@CrossOrigin(origins="localhost:4200")
@Slf4j
@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private final ServicioServicio servicioServicio;

    public ServicioController(ServicioServicio servicioServicio) {
        this.servicioServicio = servicioServicio;
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> getServicios(){

        return servicioServicio.findAll().map(servicio->servicio.isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(servicio,HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> getServicio(@PathVariable Integer id) {
        return servicioServicio.findById(id)
                .map(servicio -> new ResponseEntity<>(servicio, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Servicio> save(@Valid @RequestBody Servicio servicio) {
        return new ResponseEntity<>(servicioServicio.saveOrUpdate(servicio), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Servicio>  update(@Valid @RequestBody Servicio servicio){
        return new ResponseEntity<>(servicioServicio.saveOrUpdate(servicio), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id ){

        return servicioServicio.findById(id)==null?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(servicioServicio.deleteById(id),HttpStatus.OK);

    }
}
