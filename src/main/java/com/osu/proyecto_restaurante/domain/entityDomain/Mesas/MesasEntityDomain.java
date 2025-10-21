package com.osu.proyecto_restaurante.domain.entityDomain.Mesas;

import lombok.Data;

@Data
public class MesasEntityDomain {
    private int id_mesa;
    private int numero_mesa;
    private int id_sala;
    private boolean estado_mesa;
}
