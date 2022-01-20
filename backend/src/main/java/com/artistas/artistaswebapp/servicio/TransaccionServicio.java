package com.artistas.artistaswebapp.servicio;

import com.artistas.artistaswebapp.modelo.Transaccion;
import com.artistas.artistaswebapp.repositorio.ITransaccionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServicio implements BaseService<Transaccion,Integer> {



    private final ITransaccionRepo transaccionRepository;

    public TransaccionServicio(ITransaccionRepo transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }
    
    @Override
    public Optional<Transaccion> findById(Integer id) {

        return transaccionRepository.findById(id);
    }

    @Override
    public Optional<List<Transaccion>> findAll() {
        return Optional.of(transaccionRepository.findAll());
    }

    @Override
    public Transaccion saveOrUpdate(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    @Override
    public boolean deleteById(Integer id) {

        return findById(id).map(transaccion-> {transaccionRepository.delete(transaccion);
        return true;}).orElse( false) ;
    }
}
