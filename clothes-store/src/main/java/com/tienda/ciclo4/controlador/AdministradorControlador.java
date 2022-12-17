package com.tienda.ciclo4.controlador;

import com.tienda.ciclo4.modelo.Administrador;
import com.tienda.ciclo4.servicio.AdministradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Administrador")
@CrossOrigin(origins = "*")
public class AdministradorControlador {
    @Autowired
    private AdministradorServicio administradorServicio;

    @GetMapping("/all")
    public List<Administrador> getAll(){
        return administradorServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Administrador> getAdministrador(@PathVariable("id") String id){
        return administradorServicio.getAdministratorById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador saveAdministrador(@RequestBody Administrador administrador){
        return administradorServicio.guardarAdministrador(administrador);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador updateAdministrador(@RequestBody Administrador administrador){
        return administradorServicio.actualizarAdministrador(administrador);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAdministrador(@PathVariable("id") String id ){
        return administradorServicio.eliminarAdministrador(id);
    }
}
