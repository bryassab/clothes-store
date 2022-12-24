package com.tienda.ciclo4.repositorio.crudRepositorio;

import com.tienda.ciclo4.modelo.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCrudRepositorio extends MongoRepository<Producto, String> {
}
