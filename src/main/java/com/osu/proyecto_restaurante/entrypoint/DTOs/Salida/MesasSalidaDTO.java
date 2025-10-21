package com.osu.proyecto_restaurante.entrypoint.DTOs.Salida;

import lombok.Data;

@Data
public class MesasSalidaDTO {
    private int id_mesa;
    private int numero_mesa;
    private boolean estado_mesa;
    private int id_sala; 
}
