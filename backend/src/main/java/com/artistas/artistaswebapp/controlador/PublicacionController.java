package com.artistas.artistaswebapp.controlador;

import com.artistas.artistaswebapp.modelo.Publicacion;
import com.artistas.artistaswebapp.servicio.PublicacionServicio;
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
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private final PublicacionServicio publicacionServicio;

    public PublicacionController(PublicacionServicio publicacionServicio) {
        this.publicacionServicio = publicacionServicio;
    }

    @GetMapping
    public ResponseEntity<List<Publicacion>> getPublicacions(){

        return publicacionServicio.findAll().map(publicacion->publicacion.isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(publicacion,HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> getPublicacion(@PathVariable Integer id) {
        return publicacionServicio.findById(id)
                .map(publicacion -> new ResponseEntity<>(publicacion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Publicacion> save(@Valid @RequestBody Publicacion publicacion) {
        return new ResponseEntity<>(publicacionServicio.saveOrUpdate(publicacion), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Publicacion>  update(@Valid @RequestBody Publicacion publicacion){
        return new ResponseEntity<>(publicacionServicio.saveOrUpdate(publicacion), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id ){

        return publicacionServicio.findById(id)==null?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(publicacionServicio.deleteById(id),HttpStatus.OK);

    }
}
