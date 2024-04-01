package com.garflex.service.interfaces;

import com.garflex.entity.Informacion;
import org.springframework.web.multipart.MultipartFile;

public interface IInformacionService {
    Informacion save (Informacion Informacion, MultipartFile file);
    Informacion update (Informacion Informacion, MultipartFile file);
    Informacion findById (Integer id);
    Iterable<Informacion> findAll ();
    void delete (Informacion Informacion);
}
