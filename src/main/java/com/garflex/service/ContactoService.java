package com.garflex.service;

import com.garflex.Utils.AzureStorageService;
import com.garflex.Utils.interfaces.IEmail;
import com.garflex.entity.Contacto;
import com.garflex.repository.ContactoRepository;
import com.garflex.service.interfaces.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactoService implements IContactoService {
    @Autowired
    private ContactoRepository MensajeRepository;

    @Autowired
    private IEmail email;
    @Transactional
    @Override
    public Contacto save(Contacto Mensaje ) {
        //email.SendEmail(Mensaje);
        return MensajeRepository.save(Mensaje);
    }

    @Transactional
    @Override
    public Contacto update(Contacto Mensaje) {
        return MensajeRepository.save(Mensaje);
    }

    @Transactional(readOnly = true)
    @Override
    public Contacto findById(Integer id) {
        return MensajeRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Contacto> findAll() {
        return MensajeRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(Contacto Mensaje) {

        MensajeRepository.delete(Mensaje);
    }
    
}
