package com.garflex.controller;

import com.garflex.entity.Informacion;
import com.garflex.service.interfaces.IInformacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/informacion")
public class InformacionController {
    @Autowired
    private IInformacionService informacionService;

    @PostMapping("create")
    public Informacion create(@RequestParam("titulo") String titulo,
                           @RequestParam("descripcion") String descripcion,
                           @RequestParam("file") MultipartFile file){
        Informacion informacion = new Informacion();
        informacion.setTitulo(titulo);
        informacion.setDescripcion(descripcion);
        return informacionService.save(informacion,file);
    }

    @PutMapping("update")
    public Informacion update(@RequestParam("id") Integer id,
                           @RequestParam("titulo") String titulo,
                           @RequestParam("descripcion") String descripcion,
                           @RequestParam("fileName") String fileName,
                           @RequestParam("file") MultipartFile file){
        Informacion informacion = new Informacion();
        informacion.setId(id);
        informacion.setTitulo(titulo);
        informacion.setDescripcion(descripcion);
        informacion.setNombreArchivo(fileName);
        return informacionService.save(informacion, file);
    }

    @DeleteMapping("delete")
    public void delete (@RequestBody Informacion informacion){
        informacionService.delete(informacion);
    }

    @GetMapping("/findbyid")
    public Informacion findById (@RequestParam Integer id){
        return  informacionService.findById(id);
    }

    @GetMapping("/findall")
    public Iterable<Informacion> findAll (){
        return  informacionService.findAll();
    }

}
