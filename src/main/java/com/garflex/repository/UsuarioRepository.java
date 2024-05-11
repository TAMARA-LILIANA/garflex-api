package com.garflex.repository;

import com.garflex.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
}
