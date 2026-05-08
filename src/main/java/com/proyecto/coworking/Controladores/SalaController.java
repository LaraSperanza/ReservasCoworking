package com.proyecto.coworking.Controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.coworking.Modelos.DTOs.SalaDTO;
import com.proyecto.coworking.Modelos.DTOs.SelectorDTO;
import com.proyecto.coworking.Servicios.SalaService;

@RestController
@RequestMapping("/api/salas")
@CrossOrigin(origins = "*")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping("/selector")
    public ResponseEntity<List<SelectorDTO>> obtenerSalasParaFiltro() {
        List<SelectorDTO> salas = salaService.listarSalasParaFiltro();
        if (salas.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devuelve 204 si no hay datos
        }
        return ResponseEntity.ok(salas); // Devuelve 200 OK con el JSON
    }

    @GetMapping("/listar-salas")
    public ResponseEntity<List<SalaDTO>> obtenerTodasLasSalas() {
        List<SalaDTO> salas = salaService.listarTodas();
        if (salas.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devuelve 204 si no hay datos
        }
        return ResponseEntity.ok(salas); // Devuelve 200 OK con el JSON
    }

    @GetMapping("/por-sector/{id}")
    public ResponseEntity<List<SalaDTO>> obtenerSalasPorSector(@PathVariable("id") Long idSector) {
        List<SalaDTO> salas = salaService.obtenerSalasPorSector(idSector);
        return ResponseEntity.ok(salas); // Devuelve 200 OK con el JSON aunque la lista esté vacía.
    }

}
