package com.tienda.ciclo4.controlador;

import com.tienda.ciclo4.modelo.Producto;
import com.tienda.ciclo4.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/producto")
@CrossOrigin(origins = "*")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/all")
    public List<Producto> getAll(){
        return productoServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Producto> getProductoById(@PathVariable("id") String id){
        return productoServicio.getPorductoById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto guardarProducto(@RequestBody Producto producto  ){
        return productoServicio.guardarProducto(producto);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto actualizarProducto(@RequestBody Producto producto){
        return productoServicio.actualizarProducto(producto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean eliminarProducto(@PathVariable("id") String id){
        return productoServicio.eliminarProducto(id);
    }
}
