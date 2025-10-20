package com.osu.proyecto_restaurante.entrypoint.DTOs.Salida;

import lombok.Data;

@Data
public class PlatosSalidaDTO {
    private int id_plato;
    private String nombre_plato;
    private String descripcion_plato; 
    private String tipo_categoria;
    private int precio_plato;
}
