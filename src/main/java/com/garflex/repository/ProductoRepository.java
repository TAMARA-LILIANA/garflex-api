package com.garflex.repository;

import com.garflex.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto,Integer> {
}
