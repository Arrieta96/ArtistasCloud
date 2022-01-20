package com.artistas.artistaswebapp.modelo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @ManyToOne
    @JoinColumn(name="idUsuario",nullable = false,foreignKey = @ForeignKey(name="FK_Usuario_Cliente"))
    private Usuario usuario;

    @Size(min=3,message = "el nombre debe tener minimo 3 caracteres")
    @Column(name="nombreCliente",nullable = false,length = 70)
    private String nombreCliente;

    @Size(min=3,message = "el apellido debe tener minimo 3 caracteres")
    @Column(name="apellidoCliente",nullable = false,length = 70)
    private String apellidoCliente;

    @Size(min=9,message = "el celular debe tener minimo 9 caracteres")
    @Column(name="celularCliente",nullable = true,length = 9)
    private String celularCliente;

    @Size(min=3,message = "el correo debe tener minimo 3 caracteres")
    @Column(name="correoCliente",nullable = false,length = 100)
    private String correoCliente;

    @Size(min=1,message = "la edad debe tener minimo 1 caracteres")
    @Column(name="edadCliente",nullable = true,length = 3)
    private String edadCliente;

    @Size(min=3,message = "la dirección debe tener minimo 3 caracteres")
    @Column(name="direccionCliente",nullable = true,length = 100)
    private String direccionCliente;

    @Size(min=3,message = "la contraseña debe tener minimo 3 caracteres")
    @Column(name="contrasenaCliente",nullable = false,length = 100)
    private String contrasenaCliente;



}
