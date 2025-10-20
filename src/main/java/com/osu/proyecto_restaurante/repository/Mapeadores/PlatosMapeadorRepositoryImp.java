package com.osu.proyecto_restaurante.repository.Mapeadores;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.osu.proyecto_restaurante.domain.entityDomain.Platos.PlatosEntityDomain;
import com.osu.proyecto_restaurante.entitys.PlatoEntity;
import com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces.PlatoMaperRepository;

@Repository
public class PlatosMapeadorRepositoryImp implements PlatoMaperRepository {

    @Override
    public PlatosEntityDomain convertirADominio(PlatoEntity platoEntity) {
        PlatosEntityDomain platosEntityDomain = new PlatosEntityDomain();
        platosEntityDomain.setId_plato(platoEntity.getId_plato());
        platosEntityDomain.setNombre_plato(platoEntity.getNombre_plato());
        platosEntityDomain.setDescripcion_plato(platoEntity.getDescripcion_plato());
        platosEntityDomain.setPrecio_plato(platoEntity.getPrecio_plato());
        platosEntityDomain.setId_categoria(platoEntity.getId_categoria());
        return platosEntityDomain;
    }

    @Override
    public PlatoEntity convertirAEntidad(PlatosEntityDomain platosEntityDomain, int id_categoria) {
        PlatoEntity platoEntity = new PlatoEntity();
        platoEntity.setId_plato(platosEntityDomain.getId_plato());
        platoEntity.setNombre_plato(platosEntityDomain.getNombre_plato());
        platoEntity.setDescripcion_plato(platosEntityDomain.getDescripcion_plato());
        platoEntity.setId_categoria(id_categoria);
        platoEntity.setPrecio_plato(platosEntityDomain.getPrecio_plato());
        return platoEntity;
        
    }

    @Override
    public List<PlatosEntityDomain> convertirListADominio(List<PlatoEntity> platoEntities) {
        if (platoEntities == null) return List.of();
        return platoEntities.stream()
                .map(this::convertirADominio)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlatoEntity> convertirListAEntidad(List<PlatosEntityDomain> platosEntityDomains) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertirListAEntidad'");
    }

}
