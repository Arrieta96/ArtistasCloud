package com.artistas.artistaswebapp.controlador;

import com.artistas.artistaswebapp.modelo.Transaccion;
import com.artistas.artistaswebapp.servicio.TransaccionServicio;
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
@RequestMapping("/api/transacciones")
public class TransaccionController {

    @Autowired
    private final TransaccionServicio transaccionServicio;

    public TransaccionController(TransaccionServicio transaccionServicio) {
        this.transaccionServicio = transaccionServicio;
    }

    @GetMapping
    public ResponseEntity<List<Transaccion>> getTransaccions(){

        return transaccionServicio.findAll().map(transaccion->transaccion.isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(transaccion,HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> getTransaccion(@PathVariable Integer id) {
        return transaccionServicio.findById(id)
                .map(transaccion -> new ResponseEntity<>(transaccion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Transaccion> save(@Valid @RequestBody Transaccion transaccion) {
        return new ResponseEntity<>(transaccionServicio.saveOrUpdate(transaccion), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Transaccion>  update(@Valid @RequestBody Transaccion transaccion){
        return new ResponseEntity<>(transaccionServicio.saveOrUpdate(transaccion), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id ){

        return transaccionServicio.findById(id)==null?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(transaccionServicio.deleteById(id),HttpStatus.OK);

    }
}
