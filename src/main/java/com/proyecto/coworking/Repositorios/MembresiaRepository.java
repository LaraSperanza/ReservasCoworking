package com.proyecto.coworking.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.coworking.Modelos.Entidades.Membresia;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Long> {

}