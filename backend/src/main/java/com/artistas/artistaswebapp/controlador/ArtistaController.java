package com.artistas.artistaswebapp.controlador;

import com.artistas.artistaswebapp.modelo.Artista;
import com.artistas.artistaswebapp.servicio.ArtistaServicio;
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
@RequestMapping("/api/artistas")
public class ArtistaController {

    @Autowired
    private final ArtistaServicio artistaServicio;

    public ArtistaController(ArtistaServicio artistaServicio) {
        this.artistaServicio = artistaServicio;
    }

    @GetMapping
    public ResponseEntity<List<Artista>> getArtistas(){

        return artistaServicio.findAll().map(artista->artista.isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(artista,HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> getArtista(@PathVariable Integer id) {
        return artistaServicio.findById(id)
                .map(artista -> new ResponseEntity<>(artista, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Artista> save(@Valid @RequestBody Artista artista) {
        return new ResponseEntity<>(artistaServicio.saveOrUpdate(artista), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Artista>  update(@Valid @RequestBody Artista artista){
        return new ResponseEntity<>(artistaServicio.saveOrUpdate(artista), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id ){

        return artistaServicio.findById(id)==null?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(artistaServicio.deleteById(id),HttpStatus.OK);

    }
}
