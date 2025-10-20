package com.osu.proyecto_restaurante.domain.entityDomain.Platos;

import lombok.Data;

@Data
public class PlatosEntityDomain {
    private int id_plato;
    private String nombre_plato;
    private String descripcion_plato;
    private int id_categoria;
    private int precio_plato;
}
