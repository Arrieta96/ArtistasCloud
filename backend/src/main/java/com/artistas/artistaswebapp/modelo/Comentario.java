package com.artistas.artistaswebapp.modelo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    @Size(min=3,message = "la descripción debe tener minimo 3 caracteres")
    @Column(name="descripcionComentario",nullable = false,length = 70)
    private String descripcionComentario;

    @Column(name="calificacionComentario")
    private Integer calificacionComentario;

}
