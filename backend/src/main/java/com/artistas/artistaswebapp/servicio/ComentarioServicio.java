package com.artistas.artistaswebapp.servicio;

import com.artistas.artistaswebapp.modelo.Comentario;
import com.artistas.artistaswebapp.repositorio.IComentarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServicio implements BaseService<Comentario,Integer> {



    private final IComentarioRepo comentarioRepository;

    public ComentarioServicio(IComentarioRepo comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }
    
    @Override
    public Optional<Comentario> findById(Integer id) {

        return comentarioRepository.findById(id);
    }

    @Override
    public Optional<List<Comentario>> findAll() {
        return Optional.of(comentarioRepository.findAll());
    }

    @Override
    public Comentario saveOrUpdate(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public boolean deleteById(Integer id) {

        return findById(id).map(comentario-> {comentarioRepository.delete(comentario);
        return true;}).orElse( false) ;
    }
}
