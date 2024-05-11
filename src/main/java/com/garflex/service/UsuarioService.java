package com.garflex.service;

import com.garflex.entity.Usuario;
import com.garflex.repository.UsuarioRepository;
import com.garflex.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository UsuarioRepository;
    @Transactional
    @Override
    public Usuario save(Usuario Usuario ) {
        return UsuarioRepository.save(Usuario);
    }

    @Transactional
    @Override
    public Usuario update(Usuario Usuario) {
        return UsuarioRepository.save(Usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findById(Integer id) {
        return UsuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario login(String email, String contrasena) {
        Iterable<Usuario> usuarios = UsuarioRepository.findAll();
        for (Usuario usuario : usuarios) {
            if(usuario.getContrasena().equals(contrasena) && usuario.getContrasena().equals(contrasena)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public Iterable<Usuario> findAll() {
        return UsuarioRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(Usuario Usuario) {

        UsuarioRepository.delete(Usuario);
    }
    
}
