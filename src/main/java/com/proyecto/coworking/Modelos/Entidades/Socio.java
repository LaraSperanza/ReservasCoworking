package com.proyecto.coworking.Modelos.Entidades;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Socios")
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String email;

    @ManyToOne
    @JoinColumn(name = "membresia_id", nullable = false)
    private Membresia membresia;

    @OneToMany(mappedBy = "socio")
    private List<Reserva> reservas = new ArrayList<>();

    public Socio(){}

    public Long getId(){
        return id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setMembresia(Membresia membresia){
        this.membresia = membresia;
    }

    public Membresia getMembresia(){
        return membresia;
    }

    public void addReserva(Reserva reserva){
        this.reservas.add(reserva);
        reserva.setSocio(this);
    }

    public void setReservas(List<Reserva> reservas){
        this.reservas = reservas;
    }

    public List<Reserva> getReservas(){
        return reservas;
    }
}