package com.tienda.ciclo4.servicio;

import com.tienda.ciclo4.modelo.Administrador;
import com.tienda.ciclo4.repositorio.AdministradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServicio {

    @Autowired
    private AdministradorRepositorio administradorRepositorio;

    public List<Administrador> getAll(){
        return administradorRepositorio.getAll();
    }

    public Optional<Administrador> getAdministratorById(String id){
        return administradorRepositorio.getAdministrador(id);
    }

    public Administrador guardarAdministrador(Administrador administrador){
        if(administrador.getAdministradorId() == null){
            return  administradorRepositorio.saveAdministrador(administrador);
        }else{
            Optional<Administrador> newAdministrador = administradorRepositorio.getAdministrador(administrador.getAdministradorId());
            if (newAdministrador.isPresent()){
                return administrador;
            }else{
                return administradorRepositorio.saveAdministrador(administrador);
            }
        }
    }

    public Administrador actualizarAdministrador(Administrador administrador){
        if (administrador.getAdministradorId() != null){
            Optional<Administrador> newAdministrador = administradorRepositorio.getAdministrador(administrador.getAdministradorId());
            if (newAdministrador.isPresent()){
                if (administrador.getNombre() != null){
                    newAdministrador.get().setNombre(administrador.getNombre());
                }
                if (administrador.getApellido() != null){
                    newAdministrador.get().setApellido(administrador.getApellido());
                }
                if (administrador.getUsuario() != null){
                    newAdministrador.get().setUsuario(administrador.getUsuario());
                }
                if (administrador.getPassword() != null){
                    newAdministrador.get().setPassword(administrador.getPassword());
                }
                if (administrador.getContacto() != null){
                    newAdministrador.get().setContacto(administrador.getContacto());
                }
                administradorRepositorio.saveAdministrador(newAdministrador.get());
                return newAdministrador.get();
            }else {
                return administrador;
            }
        }else {
            return administrador;
        }
    }

    public Boolean eliminarAdministrador(String id){
        Boolean newAdministrador = getAdministratorById(id).map(administrador -> {
            administradorRepositorio.deleteAdministrador(administrador);
            return true;
        }).orElse(false);
        return newAdministrador;
    }

}
