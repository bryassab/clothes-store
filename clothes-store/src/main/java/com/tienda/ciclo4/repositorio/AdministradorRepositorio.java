package com.tienda.ciclo4.repositorio;

import com.tienda.ciclo4.modelo.Administrador;
import com.tienda.ciclo4.repositorio.crudRepositorio.AdministradorCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdministradorRepositorio {
    @Autowired
    AdministradorCrudRepositorio administradorCrudRepositorio;

    public List<Administrador> getAll(){
        return (List<Administrador>) administradorCrudRepositorio.findAll();
    }

    public Optional<Administrador> getAdministrador(String id){
        return administradorCrudRepositorio.findById(id);
    }

    public Administrador saveAdministrador(Administrador administrador){
        return administradorCrudRepositorio.save(administrador);
    }
    public void deleteAdministrador(Administrador administrador){
         administradorCrudRepositorio.delete(administrador);
    }

}
