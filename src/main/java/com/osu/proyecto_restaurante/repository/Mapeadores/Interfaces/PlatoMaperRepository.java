package com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces;

import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Platos.PlatosEntityDomain;
import com.osu.proyecto_restaurante.entitys.PlatoEntity;

public interface PlatoMaperRepository {
    public PlatosEntityDomain convertirADominio(PlatoEntity platoEntity);
    public PlatoEntity convertirAEntidad(PlatosEntityDomain platosEntityDomain);
    public List<PlatosEntityDomain> convertirListADominio(List<PlatoEntity> platoEntities);
    public List<PlatoEntity> convertirListAEntidad(List<PlatosEntityDomain> platosEntityDomains);
}
