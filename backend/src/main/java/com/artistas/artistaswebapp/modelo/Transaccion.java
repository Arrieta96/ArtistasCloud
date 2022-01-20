package com.artistas.artistaswebapp.modelo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaccion;

    @Size(min=1,message = "el codigo debe tener minimo 1 caracteres")
    @Column(name="codigoTransaccion",nullable = false,length = 50)
    private String codigoTransaccion;


    @Column(name="fechaTransaccion",nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime fechaTransaccion;

    @ManyToOne
    @JoinColumn(name="idClienteArtista",nullable = false,foreignKey = @ForeignKey(name="FK_clienteArtista_transaccion"))
    private ClienteArtista clienteArtista;



}
