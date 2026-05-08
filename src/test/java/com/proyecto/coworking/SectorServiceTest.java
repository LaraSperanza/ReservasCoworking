package com.proyecto.coworking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.proyecto.coworking.Servicios.SectorService;

@SpringBootTest
@Transactional
public class SectorServiceTest {
    
    @Autowired 
    private SectorService sectorService;

    @Test
    @DisplayName("Test para obtener la ubicación completa de un sector")
    public void obtenerUbicacionCompletaTest(){
        String ubicacionActual = sectorService.obtenerUbicacionCompleta(4L);
        String ubicacionEsperada = "Ala Norte > Piso 1 > Edificio Central";
        assertEquals(ubicacionEsperada, ubicacionActual);
    }

    
}
    

