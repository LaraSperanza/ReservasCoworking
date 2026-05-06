package com.proyecto.coworking.Modelos.DTOs;

import java.util.List;

public record SectorCompletoDTO(String nombre, String sectorPadre, List<String> subSectores, List<String> salas) {}