package com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces;

import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Mesas.SalaMesasEntityDomain;
import com.osu.proyecto_restaurante.entitys.SalaMesasEntity;

public interface SalaMesasMaperRepository {
    public SalaMesasEntity convertirAEntidad(SalaMesasEntityDomain salaMesasEntityDomain);
    public SalaMesasEntityDomain convertirADominio(SalaMesasEntity salaMesasEntity);
    public List<SalaMesasEntityDomain> convertirListADominio(List<SalaMesasEntity> listaSalaMesasEntity);
}
