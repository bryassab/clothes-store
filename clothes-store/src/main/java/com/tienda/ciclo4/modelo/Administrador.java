package com.tienda.ciclo4.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("administradores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Administrador {
    @Id
    private String administradorId;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private Long contacto;
}
