package com.artistas.artistaswebapp.modelo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Size(min=3,message = "el nombre debe tener minimo 3 caracteres")
    @Column(name="nombreUsuario",nullable = false,length = 70)
    private String nombreUsuario;

    @Size(min=3,message = "la descripción debe tener minimo 3 caracteres")
    @Column(name="descripcionUsuario",nullable = true,length = 70)
    private String descripcionUsuario;




}
