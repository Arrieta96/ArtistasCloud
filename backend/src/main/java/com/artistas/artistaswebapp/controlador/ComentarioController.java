package com.artistas.artistaswebapp.controlador;

import com.artistas.artistaswebapp.modelo.Comentario;
import com.artistas.artistaswebapp.servicio.ComentarioServicio;
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
@RequestMapping("/api/comentarios")
public class ComentarioController {

    @Autowired
    private final ComentarioServicio comentarioServicio;

    public ComentarioController(ComentarioServicio comentarioServicio) {
        this.comentarioServicio = comentarioServicio;
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> getComentarios(){

        return comentarioServicio.findAll().map(comentario->comentario.isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(comentario,HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> getComentario(@PathVariable Integer id) {
        return comentarioServicio.findById(id)
                .map(comentario -> new ResponseEntity<>(comentario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Comentario> save(@Valid @RequestBody Comentario comentario) {
        return new ResponseEntity<>(comentarioServicio.saveOrUpdate(comentario), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Comentario>  update(@Valid @RequestBody Comentario comentario){
        return new ResponseEntity<>(comentarioServicio.saveOrUpdate(comentario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id ){

        return comentarioServicio.findById(id)==null?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(comentarioServicio.deleteById(id),HttpStatus.OK);

    }
}
