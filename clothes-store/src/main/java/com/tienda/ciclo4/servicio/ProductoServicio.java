package com.tienda.ciclo4.servicio;

import com.tienda.ciclo4.modelo.Producto;
import com.tienda.ciclo4.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> getAll(){
        return productoRepositorio.getAll();
    }

    public Optional<Producto> getPorductoById(String id){
        return productoRepositorio.getProducto(id);
    }

    public Producto guardarProducto(Producto producto){
        if(producto.getProductoId() == null){
            return productoRepositorio.saveProducto(producto);
        }else {
            Optional<Producto> newProducto = productoRepositorio.getProducto(producto.getProductoId());
            if(newProducto.isPresent()){
                return producto;
            }else {
                return productoRepositorio.saveProducto(producto);
            }
        }

    }

    public Producto actualizarProducto(Producto producto){
        if (producto.getProductoId() != null){
            Optional<Producto> newProducto = productoRepositorio.getProducto(producto.getProductoId());
            if (newProducto.isPresent()){
                if (producto.getProducto() != null){
                    newProducto.get().setProducto(producto.getProducto());
                }
                if (producto.getDescripcion() != null){
                    newProducto.get().setDescripcion(producto.getDescripcion());
                }
                if (producto.getTalla() != null){
                    newProducto.get().setTalla(producto.getTalla());
                }
                if (producto.getColor() != null){
                    newProducto.get().setColor(producto.getColor());
                }
                if (producto.getCantidad() != null){
                    newProducto.get().setCantidad(producto.getCantidad());
                }
                if (producto.getPrecio() != null){
                    newProducto.get().setPrecio(producto.getPrecio());
                }

                productoRepositorio.saveProducto(newProducto.get());
                return newProducto.get();
            }else {
                return producto;
            }
        }else {
            return producto;
        }
    }

    public Boolean eliminarProducto(String id){
        Boolean newProducto = getPorductoById(id).map(producto -> {
            productoRepositorio.deletePorducto(producto);
            return true;
        }).orElse(false);
        return newProducto;
    }
}
