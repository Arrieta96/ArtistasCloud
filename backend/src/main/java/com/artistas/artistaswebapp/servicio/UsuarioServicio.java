package com.artistas.artistaswebapp.servicio;

import com.artistas.artistaswebapp.modelo.Usuario;
import com.artistas.artistaswebapp.repositorio.IUsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio implements BaseService<Usuario,Integer> {



    private final IUsuarioRepo usuarioRepository;

    public UsuarioServicio(IUsuarioRepo usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    @Override
    public Optional<Usuario> findById(Integer id) {

        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<List<Usuario>> findAll() {
        return Optional.of(usuarioRepository.findAll());
    }

    @Override
    public Usuario saveOrUpdate(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean deleteById(Integer id) {

        return findById(id).map(usuario-> {usuarioRepository.delete(usuario);
        return true;}).orElse( false) ;
    }
}
