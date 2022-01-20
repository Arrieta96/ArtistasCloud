package com.artistas.artistaswebapp.servicio;

import com.artistas.artistaswebapp.modelo.Cliente;

import com.artistas.artistaswebapp.repositorio.IClienteRepo;
import com.artistas.artistaswebapp.servicio.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio implements BaseService<Cliente,Integer> {



    private final IClienteRepo clienteRepository;

    public ClienteServicio(IClienteRepo clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    @Override
    public Optional<Cliente> findById(Integer id) {

        return clienteRepository.findById(id);
    }

    @Override
    public Optional<List<Cliente>> findAll() {
        return Optional.of(clienteRepository.findAll());
    }

    @Override
    public Cliente saveOrUpdate(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public boolean deleteById(Integer id) {

        return findById(id).map(cliente-> {clienteRepository.delete(cliente);
        return true;}).orElse( false) ;
    }
}
