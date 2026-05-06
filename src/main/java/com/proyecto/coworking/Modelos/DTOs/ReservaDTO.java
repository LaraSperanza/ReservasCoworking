package com.proyecto.coworking.Modelos.DTOs;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaDTO(SocioDTO socio, SalaDTO sala, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin){}
