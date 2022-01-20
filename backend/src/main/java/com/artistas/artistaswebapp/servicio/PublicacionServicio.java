package com.artistas.artistaswebapp.servicio;

import com.artistas.artistaswebapp.modelo.Publicacion;
import com.artistas.artistaswebapp.repositorio.IPublicacionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionServicio implements BaseService<Publicacion,Integer> {



    private final IPublicacionRepo publicacionRepository;

    public PublicacionServicio(IPublicacionRepo publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }
    
    @Override
    public Optional<Publicacion> findById(Integer id) {

        return publicacionRepository.findById(id);
    }

    @Override
    public Optional<List<Publicacion>> findAll() {
        return Optional.of(publicacionRepository.findAll());
    }

    @Override
    public Publicacion saveOrUpdate(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    public boolean deleteById(Integer id) {

        return findById(id).map(publicacion-> {publicacionRepository.delete(publicacion);
        return true;}).orElse( false) ;
    }
}
