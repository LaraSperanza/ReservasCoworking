package com.proyecto.coworking.Servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.coworking.Modelos.DTOs.SelectorDTO;
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

    public List<SelectorDTO> listarSectoresParaFiltro() {
    return sectorRepository.findAll().stream()
        .map(s -> new SelectorDTO(s.getId(), s.getNombre()))
        .collect(Collectors.toList());
    }

}
