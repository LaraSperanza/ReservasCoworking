package com.proyecto.coworking.Modelos.DTOs;

import java.math.BigDecimal;

public record SalaDTO(String nombre, Integer capacidad, BigDecimal precioHora, String ubicacionCompleta) {}
