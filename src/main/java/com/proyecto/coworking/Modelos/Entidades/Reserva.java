package com.proyecto.coworking.Modelos.Entidades;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "Reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "socio_id", nullable = false)
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;
    
    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFin;

    public Reserva(){}
    
    public Long getId(){
        return id;
    }

    public void setSocio(Socio socio){
        this.socio = socio;
    }

    public Socio getSocio(){
        return socio;
    }

    public void setSala(Sala sala){
        this.sala = sala;
    }

    public Sala getSala(){
        return sala;
    }

    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }

    public LocalDate getFecha(){
        return fecha;
    }

    public void setHoraInicio(LocalTime horaInicio){
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraInicio(){
        return horaInicio;
    }

    public void setHoraFin(LocalTime horaFin){
        this.horaFin = horaFin;
    }

    public LocalTime getHoraFin(){
        return horaFin;
    }

}