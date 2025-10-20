package com.osu.proyecto_restaurante.repository.Mapeadores;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.osu.proyecto_restaurante.domain.entityDomain.Platos.CategoriaPlatoEntityDomain;
import com.osu.proyecto_restaurante.entitys.CategoriaPlatoEntity;
import com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces.CategoriaPlatoMaperRepository;
@Repository
public class CategoriaPlatoMapeadorImp implements CategoriaPlatoMaperRepository{

    @Override
    public CategoriaPlatoEntityDomain convertirADominio(CategoriaPlatoEntity categoriaPlatoEntity) {
        CategoriaPlatoEntityDomain categoriaPlatoEntityDomain = new CategoriaPlatoEntityDomain();
        categoriaPlatoEntityDomain.setId_categoria(categoriaPlatoEntity.getId_categoria());
        categoriaPlatoEntityDomain.setTipo_categoria(categoriaPlatoEntity.getTipo_categoria());
        return categoriaPlatoEntityDomain;
    }

    @Override
    public CategoriaPlatoEntity convertirAEntidad(CategoriaPlatoEntityDomain categoriaPlatoEntityDomain) {
        CategoriaPlatoEntity categoriaPlatoEntity = new CategoriaPlatoEntity();
        categoriaPlatoEntity.setId_categoria(categoriaPlatoEntityDomain.getId_categoria());
        categoriaPlatoEntity.setTipo_categoria(categoriaPlatoEntityDomain.getTipo_categoria());
        return categoriaPlatoEntity;
    }

    @Override
    public List<CategoriaPlatoEntityDomain> convertirListADominio(List<CategoriaPlatoEntity> categoriaPlatoEntities) {
         if (categoriaPlatoEntities == null) return List.of();
        return categoriaPlatoEntities.stream()
                .map(this::convertirADominio)
                .collect(Collectors.toList());
    }

   

}
