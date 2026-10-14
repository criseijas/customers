package com.cursojava.customers.controllers;
import com.cursojava.customers.dao.UsuarioDao;
import com.cursojava.customers.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao; //injección de dependencias

    private List<Usuario> list = new ArrayList<>();

    public UsuarioController() {

        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setNombre("Griselda");
        usuario1.setApellido("Alvarez");
        usuario1.setEmail("Gri@yahoo.com.es");
        usuario1.setTelefono("1134211199");
        usuario1.setPassword("123456");


        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNombre("Facundo");
        usuario2.setApellido("Fernandez");
        usuario2.setEmail("facu@hotmail.com");
        usuario2.setTelefono("1123230102");
        usuario2.setPassword("facu987");

        list.add(usuario1);
        list.add(usuario2);
    }

    /*@GetMapping("/usuario")
    public List<Usuario> obtenerUsuarios() {
        return list;
    }*/

    @GetMapping("/usuario")
    public List<Usuario> obtenerUsuarios() {
        return usuarioDao.obtenerUsuarios();
    }

    /*@GetMapping("/usuario/{id}")
    public Usuario detalleUsuario(@PathVariable Long id) {

        for (Usuario user: list){
            if (user.getId().equals(id)){
                return user;
            }

        }
        return null;
    }*/

    @GetMapping("/usuario/{id}")
    public Usuario detalleUsuario(@PathVariable Long id) {

       return usuarioDao.detalleUsuario(id);
    }

    /*@DeleteMapping("/usuario/{id}")
    public void eliminarUsuario(@PathVariable Long id) {

        list.removeIf(user -> user.getId().equals(id));

    }*/


    @DeleteMapping("/usuario/{id}")
    public void eliminarUsuario(@PathVariable Long id) {

        usuarioDao.eliminarUsuario(id);

    }

    @PostMapping("/usuario")
    public void crearUsuario(@RequestBody Usuario usuario){

        list.add(usuario);

    }


    @PutMapping("/usuario/{id}")
    public void editarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioEditar){

        for (Usuario user: list){
            if (user.getId().equals(id)){
                user.setNombre(usuarioEditar.getNombre());
                user.setApellido(usuarioEditar.getApellido());
                user.setEmail(usuarioEditar.getEmail());
                user.setTelefono(usuarioEditar.getTelefono());
                user.setPassword(usuarioEditar.getPassword());
            }
        }

    }

}
