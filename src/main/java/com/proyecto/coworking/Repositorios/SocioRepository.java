package com.proyecto.coworking.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.coworking.Modelos.Entidades.Socio;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {

}