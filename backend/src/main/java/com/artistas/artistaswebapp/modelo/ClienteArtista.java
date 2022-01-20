package com.artistas.artistaswebapp.modelo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="ClienteArtista")

public class ClienteArtista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClienteArtista;

    @ManyToOne
    @JoinColumn(name="idCliente",nullable = false,foreignKey = @ForeignKey(name="FK_Cliente_ClienteArtista"))
    private  Cliente cliente;

    @ManyToOne
    @JoinColumn(name="idArtista",nullable = false,foreignKey = @ForeignKey(name="FK_Artista_ClienteArtista"))
    private  Artista artista;


    @ManyToOne
    @JoinColumn(name="idServicio",nullable = false,foreignKey = @ForeignKey(name="FK_Servicio_ClienteArtista"))
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name="idComentario",nullable = false,foreignKey = @ForeignKey(name="FK_Comentario_ClienteArtista"))
    private Comentario comentario;

    @Column(name="fechaReserva",nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime fechaReserva;

}
