package com.proyecto.coworking.Servicios;

import org.springframework.stereotype.Service;
import com.proyecto.coworking.Modelos.DTOs.SalaDTO;
import com.proyecto.coworking.Modelos.DTOs.SelectorDTO;
import com.proyecto.coworking.Modelos.Entidades.Sala;
import com.proyecto.coworking.Modelos.Entidades.Sector;
import com.proyecto.coworking.Repositorios.SalaRepository;
import com.proyecto.coworking.Repositorios.SectorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaService {

    private final SalaRepository salaRepository;

    private final SectorRepository sectorRepository;

    private final SectorService sectorService;

    public SalaService(SalaRepository salaRepository, SectorService sectorService, SectorRepository sectorRepository) {
        this.salaRepository = salaRepository;
        this.sectorRepository = sectorRepository;
        this.sectorService = sectorService;
    }

    public String obtenerUbicacionCompleta(Long idSala){
        return sectorService.obtenerUbicacionCompleta(salaRepository.findById(idSala).get().getSector().getId());
    }

    public SalaDTO entidadADTO(Sala sala) {
        return new SalaDTO(
                sala.getNombre(),
                sala.getCapacidad(),
                sala.getPrecioHora(),
                this.obtenerUbicacionCompleta(sala.getId())
        );
    }

    public List<SalaDTO> listarTodas() {
        return salaRepository.findAll().stream()
                .map(this::entidadADTO)
                .collect(Collectors.toList());
    }

    public List<SelectorDTO> listarSalasParaFiltro() {
        return salaRepository.findAll().stream()
            .map(s -> new SelectorDTO(s.getId(), s.getNombre()))
            .collect(Collectors.toList());
    }

    
    public List<SalaDTO> obtenerSalasPorSector(Long idSector){
        List<SalaDTO> salasTotales = new ArrayList<>();
        List<Sala> salas = salaRepository.findBySectorId(idSector);
        List<Sector> subsectores = sectorRepository.findBySectorPadreId(idSector);
        for (Sector sub : subsectores) {
            salasTotales.addAll(this.obtenerSalasPorSector(sub.getId()));
        }
        for (Sala sala : salas) {
            salasTotales.add(this.entidadADTO(sala));
        }
        return salasTotales;
    }

}