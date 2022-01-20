package com.artistas.artistaswebapp.repositorio;

import com.artistas.artistaswebapp.modelo.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepo extends IGenericRepo<Cliente,Integer>{
}
