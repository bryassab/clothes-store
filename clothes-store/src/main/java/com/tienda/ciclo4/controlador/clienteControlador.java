package com.tienda.ciclo4.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.tienda.ciclo4.modelo.cliente;
import com.tienda.ciclo4.servicio.clienteServicio;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class clienteControlador {

    @Autowired
    private clienteServicio clienteServicio;

    @GetMapping("/all")
    public List<cliente> getAll(){
        return clienteServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<cliente> getCategory(@PathVariable("id") String id){

        return clienteServicio.getCliente(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public cliente save(@RequestBody  cliente c){
        return clienteServicio.guardarCliente(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public cliente update(@RequestBody cliente c){
        return clienteServicio.actualizarCliente(c);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") String id){
        return clienteServicio.eliminarCliente(id);
    }
}