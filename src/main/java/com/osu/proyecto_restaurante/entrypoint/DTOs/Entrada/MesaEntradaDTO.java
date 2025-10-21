package com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada;

import lombok.Data;

@Data
public class MesaEntradaDTO {
    private int id_mesa;
    private int numero_mesa;
    private boolean estado_mesa;
    private int id_sala;
}
