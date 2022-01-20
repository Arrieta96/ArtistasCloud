package com.artistas.artistaswebapp.modelo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;

    @Size(min=3,message = "el nombre debe tener minimo 3 caracteres")
    @Column(name="nombreServicio",nullable = false,length = 70)
    private String nombreServicio;

    @Size(min=3,message = "la descripción debe tener minimo 3 caracteres")
    @Column(name="descripcionServicio",nullable = false,length = 200)
    private String descripcionServicio;

    @Column(name="precioServicio")
    Double precioServicio;

}
