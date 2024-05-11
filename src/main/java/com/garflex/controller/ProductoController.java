package com.garflex.controller;

import com.garflex.entity.Producto;
import com.garflex.service.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/producto")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @PostMapping("create")
    public Producto create(@RequestParam("nombre") String nombre,
                           @RequestParam("descripcion") String descripcion,
                           @RequestParam("precio") int precio,
                           @RequestParam("stock") int stock,
                           @RequestParam("tipo") int tipo,
                           @RequestParam("file") MultipartFile file) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setTipo(tipo);

        return productoService.save(producto,file);
    }

    @PutMapping("update")
    public Producto update(@RequestParam("id") Integer id,
                           @RequestParam("nombre") String nombre,
                           @RequestParam("descripcion") String descripcion,
                           @RequestParam("precio") int precio,
                           @RequestParam("stock") int stock,
                           @RequestParam("fileName") String fileName,
                           @RequestParam("tipo") int tipo,
                           @RequestParam("file") MultipartFile file){
        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setNombreArchivo(fileName);
        producto.setTipo(tipo);
        return productoService.save(producto,file);
    }


    @DeleteMapping("delete")
    public void delete (@RequestBody Producto producto){

        productoService.delete(producto);
    }

    @GetMapping("/findbyid")
    public Producto findById (@RequestParam Integer id){
        return  productoService.findById(id);
    }

    @GetMapping("/findbyidtype")
    public Iterable<Producto> findbyidtype (@RequestParam Integer id){
        return  productoService.findByIdType(id);
    }

    @GetMapping("/findall")
    public Iterable<Producto> findAll (){
        return  productoService.findAll();
    }

}
