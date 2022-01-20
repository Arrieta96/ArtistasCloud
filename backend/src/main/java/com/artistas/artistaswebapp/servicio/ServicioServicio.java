package com.artistas.artistaswebapp.servicio;

import com.artistas.artistaswebapp.modelo.Servicio;
import com.artistas.artistaswebapp.repositorio.IServicioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServicio implements BaseService<Servicio,Integer> {



    private final IServicioRepo servicioRepository;

    public ServicioServicio(IServicioRepo servicioRepository) {
        this.servicioRepository = servicioRepository;
    }
    
    @Override
    public Optional<Servicio> findById(Integer id) {

        return servicioRepository.findById(id);
    }

    @Override
    public Optional<List<Servicio>> findAll() {
        return Optional.of(servicioRepository.findAll());
    }

    @Override
    public Servicio saveOrUpdate(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public boolean deleteById(Integer id) {

        return findById(id).map(servicio-> {servicioRepository.delete(servicio);
        return true;}).orElse( false) ;
    }
}
