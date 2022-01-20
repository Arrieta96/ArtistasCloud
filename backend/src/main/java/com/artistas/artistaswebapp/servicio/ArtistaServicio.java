package com.artistas.artistaswebapp.servicio;
import com.artistas.artistaswebapp.modelo.Artista;
import com.artistas.artistaswebapp.repositorio.IArtistaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaServicio implements BaseService<Artista,Integer>{



    private final IArtistaRepo artistaRepository;

    public ArtistaServicio(IArtistaRepo artistaRepository) {
        this.artistaRepository = artistaRepository;
    }
    
    @Override
    public Optional<Artista> findById(Integer id) {

        return artistaRepository.findById(id);
    }

    @Override
    public Optional<List<Artista>> findAll() {
        return Optional.of(artistaRepository.findAll());
    }

    @Override
    public Artista saveOrUpdate(Artista artista) {
        return artistaRepository.save(artista);
    }

    @Override
    public boolean deleteById(Integer id) {

        return findById(id).map(artista-> {artistaRepository.delete(artista);
        return true;}).orElse( false) ;
    }
}
