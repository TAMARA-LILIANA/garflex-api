package com.garflex.controller;

import com.garflex.entity.Carrusel;
import com.garflex.service.interfaces.ICarruselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/carrusel")
public class CarruselController {
    @Autowired
    private ICarruselService carruselService;

    @PostMapping("create")
    public Carrusel create(@RequestParam("nombre") String nombre,
                           @RequestParam("descripcion") String descripcion,
                           @RequestParam("file") MultipartFile file){
        Carrusel carrusel = new Carrusel();
        carrusel.setNombre(nombre);
        carrusel.setDescripcion(descripcion);
        return carruselService.save(carrusel,file);
    }

    @PutMapping("update")
    public Carrusel update(@RequestParam("id") Integer id,
                           @RequestParam("nombre") String nombre,
                           @RequestParam("descripcion") String descripcion,
                           @RequestParam("fileName") String fileName,
                           @RequestParam("file") MultipartFile file){
        Carrusel carrusel = new Carrusel();
        carrusel.setId(id);
        carrusel.setNombre(nombre);
        carrusel.setDescripcion(descripcion);
        carrusel.setNombreArchivo(fileName);
        return carruselService.save(carrusel, file);
    }

    @DeleteMapping("delete")
    public void delete (@RequestBody Carrusel carrusel){
        carruselService.delete(carrusel);
    }

    @GetMapping("/findbyid")
    public Carrusel findById (@RequestParam Integer id){
        return  carruselService.findById(id);
    }

    @GetMapping("/findall")
    public Iterable<Carrusel> findAll (){
        return  carruselService.findAll();
    }


}
