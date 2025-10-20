package com.osu.proyecto_restaurante.entitys;

import lombok.Data;

@Data
public class PlatoEntity {
    private int id_plato;
    private String nombre_plato;
    private String descripcion_plato; 
    private int id_categoria;
    private int precio_plato;
}
