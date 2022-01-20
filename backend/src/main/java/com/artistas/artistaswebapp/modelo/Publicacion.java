package com.artistas.artistaswebapp.modelo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublicacion;

    @Size(min=3,message = "la descripcion debe tener minimo 3 caracteres")
    @Column(name="descripcionPublicacion",nullable = false,length = 70)
    private String descripcionPublicacion;

    @Size(min=3,message = "el enlace debe tener minimo 3 caracteres")
    @Column(name="videoPublicacion",nullable = true,length = 400)
    private String videoPublicacion;

    @ManyToOne
    @JoinColumn(name="idArtista",nullable = false,foreignKey = @ForeignKey(name="FK_Artista_Publicacion"))
    private Artista artista;
}
