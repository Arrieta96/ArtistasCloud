package com.artistas.artistaswebapp.repositorio;

import com.artistas.artistaswebapp.modelo.Comentario;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentarioRepo extends IGenericRepo<Comentario,Integer>{
}
