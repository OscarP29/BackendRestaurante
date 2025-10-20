package com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada;

import lombok.Data;

@Data
public class PlatoEntradaDTO {
    private int id_plato;
    private String nombre_plato;
    private String descripcion_plato;
    private String categoria_plato;
    private int precio_plato;
}
