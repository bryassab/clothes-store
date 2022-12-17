package com.tienda.ciclo4.repositorio.crudRepositorio;

import com.tienda.ciclo4.modelo.Administrador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorCrudRepositorio extends MongoRepository<Administrador, String> {

    Optional<Administrador> findOneByUsuario(String Usuario);
}
