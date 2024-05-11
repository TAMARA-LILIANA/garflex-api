package com.garflex.service.interfaces;

import com.garflex.entity.Contacto;

public interface IContactoService {
    Contacto save (Contacto mensaje);
    Contacto update (Contacto mensaje);
    Contacto findById (Integer id);
    Iterable<Contacto> findAll ();
    void delete (Contacto mensaje);
}
