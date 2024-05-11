package com.garflex.controller;

import com.garflex.entity.Contacto;
import com.garflex.service.interfaces.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/contacto")
public class ContactoController {
    @Autowired
    private IContactoService contactService;

    @PostMapping("create")
    public Contacto create(@RequestBody Contacto contact){
        return contactService.save(contact);
    }

    @PutMapping("update")
    public Contacto update(@RequestBody Contacto contact){
        return contactService.save(contact);
    }

    @DeleteMapping("delete")
    public void delete (@RequestBody Contacto contact){
        contactService.delete(contact);
    }

    @GetMapping("/findbyid")
    public Contacto findById (@RequestParam Integer id){
        return  contactService.findById(id);
    }

    @GetMapping("/findall")
    public Iterable<Contacto> findAll (){
        return  contactService.findAll();
    }

}
