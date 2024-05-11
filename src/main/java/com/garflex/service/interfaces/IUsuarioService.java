package com.garflex.service.interfaces;

import com.garflex.entity.Usuario;

public interface IUsuarioService {
    Usuario save (Usuario usuario);
    Usuario update (Usuario usuario);
    Usuario findById (Integer id);
    Usuario login (String email, String contrasena);
    Iterable<Usuario> findAll ();
    void delete (Usuario usuario);
}
