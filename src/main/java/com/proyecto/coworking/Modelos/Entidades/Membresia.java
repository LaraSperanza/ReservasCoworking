package com.proyecto.coworking.Modelos.Entidades;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Membresias")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer capacidadMaxSala;

    @OneToMany(mappedBy = "membresia")
    private List<Socio> socios = new ArrayList<>();

    public Membresia(){}

    public Long getId(){
        return id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setCapacidadMaxSala(Integer capacidad){
        this.capacidadMaxSala = capacidad;
    }

    public Integer getCapacidadMaxSala(){
        return capacidadMaxSala;
    }

    public void addSocio(Socio socio){
        this.socios.add(socio);
        socio.setMembresia(this);
    }

    public void setSocios(List<Socio> socios){
        this.socios = socios;
    }

    public List<Socio> getSocios(){
        return socios;
    }
}