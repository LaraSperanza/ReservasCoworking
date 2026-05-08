package com.proyecto.coworking.Servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyecto.coworking.Modelos.Entidades.Sector;
import com.proyecto.coworking.Repositorios.SectorRepository;

@Service
public class SectorService {
    
    private final SectorRepository sectorRepository;

    public SectorService(SectorRepository sectorRepository){
        this.sectorRepository = sectorRepository;
    }


    @Transactional(readOnly = true)
    public String obtenerUbicacionCompleta(Long idSector){
        List<String> ubicacionCompleta = new ArrayList<>();
        Sector padre = sectorRepository.findById(idSector).get();
        while (padre != null) {
            ubicacionCompleta.add(padre.getNombre());
            padre = padre.getSectorPadre();
        }
        return String.join(" > ", ubicacionCompleta);
    }

}
