package com.proyecto.coworking.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.coworking.Modelos.Entidades.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    List<Sala> findBySectorId(Long idSector);

}