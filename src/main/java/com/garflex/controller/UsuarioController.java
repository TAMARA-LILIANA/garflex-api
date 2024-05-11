package com.garflex.controller;

import com.garflex.entity.Usuario;
import com.garflex.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("create")
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @PutMapping("update")
    public Usuario update(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @DeleteMapping("delete")
    public void delete (@RequestBody Usuario usuario){
        usuarioService.delete(usuario);
    }

    @GetMapping("/findbyid")
    public Usuario findById (@RequestParam Integer id){
        return  usuarioService.findById(id);
    }

    @GetMapping("/login")
    public Usuario findById (@RequestParam String email, String contrasena){
        return  usuarioService.login(email,contrasena);
    }

    @GetMapping("/findall")
    public Iterable<Usuario> findAll (){
        return  usuarioService.findAll();
    }

}
