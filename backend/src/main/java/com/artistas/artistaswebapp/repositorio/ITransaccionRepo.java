package com.artistas.artistaswebapp.repositorio;

import com.artistas.artistaswebapp.modelo.Transaccion;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransaccionRepo extends IGenericRepo<Transaccion,Integer>{
}
