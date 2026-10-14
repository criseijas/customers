package com.cursojava.customers.dao;

import com.cursojava.customers.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> obtenerUsuarios();

    void eliminarUsuario(Long id);

    Usuario detalleUsuario(Long id);
}
