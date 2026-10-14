package com.cursojava.customers.dao;
import com.cursojava.customers.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager; //sirve para hacer la conexión con la Base de Datos

    @Override
    public List<Usuario> obtenerUsuarios() {
        String query = "FROM Usuario"; //Usuario se refiere al objeto
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminarUsuario(Long id) {

        Usuario usuario = entityManager.find(Usuario.class ,id);
        entityManager.remove(usuario);
    }

    @Override
    public Usuario detalleUsuario(Long id) {

        Usuario usuario = entityManager.find(Usuario.class ,id);
        return entityManager.find(Usuario.class, id);
    }
}
