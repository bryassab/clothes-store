package com.tienda.ciclo4.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("productos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Producto {

    @Id
    private String productoId;
    private String producto;
    private String descripcion;
    private String talla;
    private String color;
    private Integer cantidad;
    private Integer precio;


}
