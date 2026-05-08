package com.proyecto.coworking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.coworking.Modelos.DTOs.SalaDTO;
import com.proyecto.coworking.Servicios.SalaService;

@SpringBootTest
@Transactional
public class SalaServiceTest {

    @Autowired 
    private SalaService salaService;

    @Test
    @DisplayName("Test de listado de todas las salas")
    public void listarTodas() {
        int cantidadSalasEsperada = 2; 
        int cantidadSalasObtenida = salaService.listarTodas().size();
        assertEquals(cantidadSalasEsperada, cantidadSalasObtenida);
    }

    @Test
    @DisplayName("Test de obtención de ubicación completa de una sala") 
    public void obtenerUbicacionCompleta(){
        Long idSala = 1L; 
        String ubicacionEsperada = "Ala Norte > Piso 1 > Edificio Central"; 
        String ubicacionObtenida = salaService.obtenerUbicacionCompleta(idSala);
        assertEquals(ubicacionEsperada, ubicacionObtenida);
    }

    @Test   
    @DisplayName("Test de obtención de salas por sector")
    public void obtenerSalasPorSector(){
        List<SalaDTO> resultado = salaService.obtenerSalasPorSector(1L);

        assertThat(resultado)
            .as("Debe mapear los nombres de las salas correctamente")
            .extracting(SalaDTO::nombre)
            .contains("Sala de Reuniones A", "Auditorio Principal");
    }
  
} 