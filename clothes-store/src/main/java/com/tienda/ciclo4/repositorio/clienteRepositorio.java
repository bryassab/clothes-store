package com.tienda.ciclo4.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tienda.ciclo4.modelo.cliente;
import com.tienda.ciclo4.repositorio.crudRepositorio.clienteCrudRepositorio;

@Repository
public class clienteRepositorio {

    @Autowired
    private clienteCrudRepositorio clienteCrudRepositorio;

    public List<cliente> getAll(){

        return (List<cliente>) clienteCrudRepositorio.findAll();
    }

    public Optional<cliente> getCliente(String id){
        return clienteCrudRepositorio.findById(id);
    }

    public cliente save(cliente C){

        return clienteCrudRepositorio.save(C);
    }

    public void delete(cliente c){

        clienteCrudRepositorio.delete(c);
    }
}

    

