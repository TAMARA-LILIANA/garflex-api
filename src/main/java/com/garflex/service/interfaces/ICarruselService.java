package com.garflex.service.interfaces;

import com.garflex.entity.Carrusel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICarruselService {
    Carrusel save (Carrusel carrusel, MultipartFile file);
    Carrusel update (Carrusel carrusel, MultipartFile file);
    Carrusel findById (Integer id);
    Iterable<Carrusel> findAll ();
    void delete (Carrusel carrusel);
}
