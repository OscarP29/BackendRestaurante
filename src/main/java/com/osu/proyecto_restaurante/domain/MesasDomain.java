package com.osu.proyecto_restaurante.domain;

import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Mesas.MesasEntityDomain;

public interface MesasDomain {
    public boolean InsertarMesa(MesasEntityDomain mesasEntityDomain);
    public boolean EditarMesa(MesasEntityDomain mesasEntityDomain);
    public boolean EliminarMesa(int id_mesa);
    public List<MesasEntityDomain> ObtenerMesas();
    public boolean CambiarEstadoMesa(int id_mesa, boolean estado_mesa);
}
