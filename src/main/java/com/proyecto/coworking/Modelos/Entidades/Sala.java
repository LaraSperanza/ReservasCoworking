package com.proyecto.coworking.Modelos.Entidades;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Salas")
public class Sala{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false)
    private Integer capacidad;

    @Column(nullable = false)
    private BigDecimal precioHora;

    @ManyToOne
    @JoinColumn(name = "sector_id", nullable = false)
    private Sector sector;

    @OneToMany(mappedBy = "sala")
    private List<Reserva> reservas = new ArrayList<>();

    public Sala(){}

    public Sala(String nombre, Integer capacidad, BigDecimal precioHora){
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioHora = precioHora;
    }

    public Long getId(){
        return id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setCapacidad(Integer capacidad){
        this.capacidad = capacidad;
    }

    public Integer getCapacidad(){
        return capacidad;
    }

    public void setPrecioHora(BigDecimal precioHora){
        this.precioHora = precioHora;
    }

    public BigDecimal getPrecioHora(){
        return precioHora;
    }

    public void setSector(Sector sector){
        this.sector = sector;
    }

    public Sector getSector(){
        return sector;
    }

    public void addReserva(Reserva reserva){
        this.reservas.add(reserva);
        reserva.setSala(this);
    }

    public void setReservas(List<Reserva> reservas){
        this.reservas = reservas;
    }

    public List<Reserva> getReservas(){
        return reservas;
    }
}