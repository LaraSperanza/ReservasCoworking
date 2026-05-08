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


}