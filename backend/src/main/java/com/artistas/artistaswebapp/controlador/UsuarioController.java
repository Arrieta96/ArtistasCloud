package com.artistas.artistaswebapp.controlador;

import com.artistas.artistaswebapp.modelo.Usuario;
import com.artistas.artistaswebapp.servicio.UsuarioServicio;
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
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioServicio usuarioServicio;

    public UsuarioController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios(){

        return usuarioServicio.findAll().map(usuario->usuario.isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(usuario,HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) {
        return usuarioServicio.findById(id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioServicio.saveOrUpdate(usuario), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Usuario>  update(@Valid @RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioServicio.saveOrUpdate(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id ){

        return usuarioServicio.findById(id)==null?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(usuarioServicio.deleteById(id),HttpStatus.OK);

    }
}
