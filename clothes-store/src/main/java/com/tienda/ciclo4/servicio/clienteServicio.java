package com.tienda.ciclo4.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.ciclo4.modelo.cliente;
import com.tienda.ciclo4.repositorio.clienteRepositorio;

@Service
public class clienteServicio {

    @Autowired
    private clienteRepositorio clienteRepositorio;

    public List<cliente> getAll(){
        return clienteRepositorio.getAll();
    }
    public Optional<cliente> getCliente(String id){
        return clienteRepositorio.getCliente(id);
    }
    public cliente guardarCliente(cliente c){
        if(c.getId()==null){
            return clienteRepositorio.save(c);
        }else{
            Optional<cliente> e = clienteRepositorio.getCliente(c.getId());
            if(e.isPresent()){
                return c;
            }else{
                return clienteRepositorio.save(c);
            }
        }
    }
    public cliente actualizarCliente(cliente c){
        if(c.getId()!=null){
            Optional<cliente> q = clienteRepositorio.getCliente(c.getId());
            if(q.isPresent()){
                if(c.getNombre()!=null){
                    q.get().setNombre(c.getNombre());
                }
                if(c.getApellido()!=null){
                    q.get().setApellido(c.getApellido());
                }
                if(c.getCorreo()!=null){
                    q.get().setCorreo(c.getCorreo());
                }
                if(c.getPassword()!=null){
                    q.get().setPassword(c.getPassword());
                }
                if(c.getDireccion()!=null){
                    q.get().setDireccion(c.getDireccion());
                }
                if(c.getContacto()!=null){
                    q.get().setContacto(c.getContacto());
                }
                clienteRepositorio.save(q.get());
                return q.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }
    public boolean eliminarCliente(String id){
        Boolean d = getCliente(id).map(c -> {
            clienteRepositorio.delete(c);
            return true;
        }).orElse(false);
        return d;
    }


}