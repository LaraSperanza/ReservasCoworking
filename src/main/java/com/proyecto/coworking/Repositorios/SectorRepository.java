package com.proyecto.coworking.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.coworking.Modelos.Entidades.Sector;
import java.util.List;


@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {

    List<Sector> findByNombre(String nombre);

    List<Sector> findBySectorPadreId(Long id);

}