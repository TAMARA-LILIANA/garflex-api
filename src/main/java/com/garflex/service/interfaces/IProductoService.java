package com.garflex.service.interfaces;

import com.garflex.entity.Producto;
import org.springframework.web.multipart.MultipartFile;

public interface IProductoService {
    Producto save (Producto Producto, MultipartFile file);
    Producto update (Producto Producto, MultipartFile file);
    Producto findById (Integer id);
    Iterable<Producto> findByIdType (Integer id);
    Iterable<Producto> findAll ();
    void delete (Producto Producto);
}
