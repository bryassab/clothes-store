package com.tienda.ciclo4.repositorio;

import com.tienda.ciclo4.modelo.Producto;
import com.tienda.ciclo4.repositorio.crudRepositorio.ProductoCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepositorio {

    @Autowired
    private ProductoCrudRepositorio productoCrudRepositorio;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepositorio.findAll();
    }

    public Optional<Producto> getProducto(String id){
        return productoCrudRepositorio.findById(id);
    }

    public Producto saveProducto(Producto producto){
        return productoCrudRepositorio.save(producto);
    }

    public void deletePorducto(Producto producto){
        productoCrudRepositorio.delete(producto);
    }

}
