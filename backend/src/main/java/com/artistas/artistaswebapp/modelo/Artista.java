package com.artistas.artistaswebapp.modelo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="artista")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArtista;

    @ManyToOne
    @JoinColumn(name="idUsuario",nullable = false,foreignKey = @ForeignKey(name="FK_Usuario_Artista"))
    private Usuario usuario;

    @Size(min=3,message = "el nombre debe tener minimo 3 caracteres")
    @Column(name="nombreArtista",nullable = false,length = 70)
    private String nombreArtista;

    @Size(min=3,message = "el apellido debe tener minimo 3 caracteres")
    @Column(name="apellidoArtista",nullable = false,length = 70)
    private String apellidoArtista;

    @Size(min=9,message = "el celular debe tener minimo 9 caracteres")
    @Column(name="celularArtista",nullable = true,length = 9)
    private String celularArtista;

    @Size(min=3,message = "el correo debe tener minimo 3 caracteres")
    @Column(name="correoArtista",nullable = false,length = 100)
    private String correoArtista;

    @Size(min=1,message = "la edad debe tener minimo 1 caracteres")
    @Column(name="edadArtista",nullable = true,length = 3)
    private String edadArtista;

    @Size(min=3,message = "la dirección debe tener minimo 3 caracteres")
    @Column(name="direccionArtista",nullable = true,length = 100)
    private String direccionArtista;

    @Size(min=3,message = "la contraseña debe tener minimo 3 caracteres")
    @Column(name="contrasenaArtista",nullable = false,length = 100)
    private String contrasenaArtista;





}
