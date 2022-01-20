package com.artistas.artistaswebapp.servicio;
import com.artistas.artistaswebapp.modelo.ClienteArtista;
import com.artistas.artistaswebapp.repositorio.IClienteArtistaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteArtistaServicio implements BaseService<ClienteArtista,Integer>{



    private final IClienteArtistaRepo artistaRepository;

    public ClienteArtistaServicio(IClienteArtistaRepo artistaRepository) {
        this.artistaRepository = artistaRepository;
    }
    
    @Override
    public Optional<ClienteArtista> findById(Integer id) {

        return artistaRepository.findById(id);
    }

    @Override
    public Optional<List<ClienteArtista>> findAll() {
        return Optional.of(artistaRepository.findAll());
    }

    @Override
    public ClienteArtista saveOrUpdate(ClienteArtista clienteArtista) {
        return artistaRepository.save(clienteArtista);
    }

    @Override
    public boolean deleteById(Integer id) {

        return findById(id).map(clienteArtista-> {artistaRepository.delete(clienteArtista);
        return true;}).orElse( false) ;
    }
}
