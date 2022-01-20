package com.artistas.artistaswebapp.repositorio;

import com.artistas.artistaswebapp.modelo.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepo extends IGenericRepo<Usuario,Integer>{
}
