package com.proyecto.coworking.Controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.coworking.Modelos.DTOs.SectorSelectorDTO;
import com.proyecto.coworking.Servicios.SectorService;

@RestController
@RequestMapping("/api/sectores")
// @CrossOrigin(origins = "*") usar si tira error con el frontend
public class SectorController {
    private final SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping("/selector")
    public ResponseEntity<List<SectorSelectorDTO>> obtenerSectoresParaFiltro() {
        List<SectorSelectorDTO> sectores = sectorService.listarSectoresParaFiltro();
        if (sectores.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devuelve 204 si no hay datos
        }
        return ResponseEntity.ok(sectores); // Devuelve 200 OK con el JSON
    }
}
