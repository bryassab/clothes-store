package com.tienda.ciclo4.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("clientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class cliente {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private String direccion;
    private Long contacto;
}