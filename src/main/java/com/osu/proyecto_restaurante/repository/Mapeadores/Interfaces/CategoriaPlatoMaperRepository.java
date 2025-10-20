package com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces;

import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Platos.CategoriaPlatoEntityDomain;
import com.osu.proyecto_restaurante.entitys.CategoriaPlatoEntity;

public interface CategoriaPlatoMaperRepository {
    public CategoriaPlatoEntityDomain convertirADominio(CategoriaPlatoEntity categoriaPlatoEntity);
    public CategoriaPlatoEntity convertirAEntidad(CategoriaPlatoEntityDomain categoriaPlatoEntityDomain);
    public List<CategoriaPlatoEntityDomain> convertirListADominio(List<CategoriaPlatoEntity> categoriaPlatoEntities);
}
