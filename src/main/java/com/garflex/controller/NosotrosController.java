package com.garflex.controller;

import com.garflex.entity.Nosotros;
import com.garflex.service.interfaces.INosotrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/nosotros")
public class NosotrosController {
    @Autowired
    private INosotrosService nosotrosService;

    @PostMapping("create")
    public Nosotros create(@RequestParam("nombre") String nombre,
                           @RequestParam("descripcion") String descripcion,
                           @RequestParam("file") MultipartFile file) {
        Nosotros nosotros = new Nosotros();
        nosotros.setNombre(nombre);
        nosotros.setDescripcion(descripcion);

        return nosotrosService.save(nosotros,file);
    }

    @PutMapping("update")
    public Nosotros update(@RequestParam("id") Integer id,
                           @RequestParam("nombre") String nombre,
                           @RequestParam("descripcion") String descripcion,
                           @RequestParam("fileName") String fileName,
                           @RequestParam("file") MultipartFile file){
        Nosotros nosotros = new Nosotros();
        nosotros.setId(id);
        nosotros.setNombre(nombre);
        nosotros.setDescripcion(descripcion);
        nosotros.setNombreArchivo(fileName);
        return nosotrosService.save(nosotros,file);
    }


    @DeleteMapping("delete")
    public void delete (@RequestBody Nosotros nosotros){
        nosotrosService.delete(nosotros);
    }

    @GetMapping("/findbyid")
    public Nosotros findById (@RequestParam Integer id){
        return  nosotrosService.findById(id);
    }

    @GetMapping("/findall")
    public Iterable<Nosotros> findAll (){
        return  nosotrosService.findAll();
    }

}
