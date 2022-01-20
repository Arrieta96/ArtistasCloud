package com.artistas.artistaswebapp.controlador;

import com.artistas.artistaswebapp.modelo.Artista;
import com.artistas.artistaswebapp.modelo.ClienteArtista;
import com.artistas.artistaswebapp.servicio.ClienteArtistaServicio;
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
@RequestMapping("/api/clienteArtistas")
public class ClienteArtistaController {

    @Autowired
    private final ClienteArtistaServicio clienteArtistaServicio;

    public ClienteArtistaController(ClienteArtistaServicio clienteArtistaServicio) {
        this.clienteArtistaServicio = clienteArtistaServicio;
    }


    @GetMapping
    public ResponseEntity<List<ClienteArtista>> getClienteArtistas(){

        return clienteArtistaServicio.findAll().map(clienteArtistas->clienteArtistas.isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(clienteArtistas,HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteArtista> getClienteArtista(@PathVariable Integer id) {
        return clienteArtistaServicio.findById(id)
                .map(clienteArtista -> new ResponseEntity<>(clienteArtista, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<ClienteArtista> save(@Valid @RequestBody ClienteArtista clienteArtista) {
        return new ResponseEntity<>(clienteArtistaServicio.saveOrUpdate(clienteArtista), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClienteArtista>  update(@Valid @RequestBody ClienteArtista clienteArtista){
        return new ResponseEntity<>(clienteArtistaServicio.saveOrUpdate(clienteArtista), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id ){

        return clienteArtistaServicio.findById(id)==null?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(clienteArtistaServicio.deleteById(id),HttpStatus.OK);

    }
}
