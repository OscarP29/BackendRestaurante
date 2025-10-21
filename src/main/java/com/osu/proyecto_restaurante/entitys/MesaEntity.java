package com.osu.proyecto_restaurante.entitys;

import lombok.Data;

@Data
public class MesaEntity {
    private int id_mesa;
    private int numero_mesa;
    private boolean estado_mesa;
    private int id_sala;
}
