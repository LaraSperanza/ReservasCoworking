package com.proyecto.coworking.Modelos.Entidades;
import java.math.BigDecimal;
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
    private BigDecimal precioMensual;

    @Column(nullable = false)
    private BigDecimal porcentajeDescuento;

    @Column(nullable = false)
    private Integer limiteHorasMensuales;

    @Column(nullable = false)
    private Boolean permiteAuditorios;

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

    public void setPrecioMensual(BigDecimal precioMensual){
        this.precioMensual = precioMensual;
    }

    public BigDecimal getPrecioMensual(){
        return precioMensual;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento){
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public BigDecimal getPorcentajeDescuento(){
        return porcentajeDescuento;
    }

    public void setLimiteHorasMensuales(Integer limiteHorasMensuales){
        this.limiteHorasMensuales = limiteHorasMensuales;
    }

    public Integer getLimiteHorasMensuales(){
        return limiteHorasMensuales;
    }   

    public void setPermiteAuditorios(Boolean permiteAuditorios){
        this.permiteAuditorios = permiteAuditorios;
    }

    public Boolean getPermiteAuditorios(){
        return permiteAuditorios;
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