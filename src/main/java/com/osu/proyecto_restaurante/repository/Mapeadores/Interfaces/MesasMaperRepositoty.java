package com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces;

import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Mesas.MesasEntityDomain;
import com.osu.proyecto_restaurante.entitys.MesaEntity;

public interface MesasMaperRepositoty {
    public MesaEntity convertirAEntidad(MesasEntityDomain mesasEntityDomain);
    public MesasEntityDomain convertirADominio(MesaEntity mesaEntity);
    public List<MesasEntityDomain> convertirListADominio(List<MesaEntity> listaMesasEntity);
}
