package com.tienda.ciclo4.repositorio.crudRepositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tienda.ciclo4.modelo.cliente;

public interface clienteCrudRepositorio extends MongoRepository<cliente, String> {
}