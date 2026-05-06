package com.proyecto.coworking.Modelos.Entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Sectores")
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "padre_id", nullable = true)
    private Sector sectorPadre;

    @OneToMany(mappedBy = "sectorPadre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sector> subSectores = new ArrayList<>();

    @OneToMany(mappedBy = "sector")
    private List<Sala> salas = new ArrayList<>();

    public Sector (){}

    public Sector (String nombre, Sector sectorPadre){
        this.nombre = nombre;
        this.sectorPadre = sectorPadre;
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

    public void setSectorPadre(Sector sectorPadre){
        this.sectorPadre = sectorPadre;
    }

    public Sector getSectorPadre(){
        return sectorPadre;
    }

    public List<Sector> getSubSectores(){ 
        return subSectores; 
    }

    public void setSubSectores(List<Sector> subSectores){ 
        this.subSectores = subSectores; 
    }

    public void addSala(Sala sala){
        this.salas.add(sala);
        sala.setSector(this);
    }

    public void setSalas(List<Sala> salas){
        this.salas = salas;
    }

    public List<Sala> getSalas(){
        return salas;
    }

    public void agregarSubSector(Sector hijo) {
        subSectores.add(hijo);
        hijo.setSectorPadre(this);
    }
}