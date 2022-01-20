package com.artistas.artistaswebapp.controlador;

import com.artistas.artistaswebapp.modelo.Cliente;
import com.artistas.artistaswebapp.servicio.ClienteServicio;
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
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private final ClienteServicio clienteServicio;

    public ClienteController(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes(){

        return clienteServicio.findAll().map(cliente->cliente.isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(cliente,HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Integer id) {
        return clienteServicio.findById(id)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteServicio.saveOrUpdate(cliente), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente>  update(@Valid @RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteServicio.saveOrUpdate(cliente), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id ){

        return clienteServicio.findById(id)==null?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(clienteServicio.deleteById(id),HttpStatus.OK);

    }
}
