package com.garflex.service.interfaces;

import com.garflex.entity.Nosotros;
import org.springframework.web.multipart.MultipartFile;

public interface INosotrosService {
    Nosotros save (Nosotros Nosotros, MultipartFile file);
    Nosotros update (Nosotros Nosotros, MultipartFile file);
    Nosotros findById (Integer id);
    Iterable<Nosotros> findAll ();
    void delete (Nosotros Nosotros);

}
