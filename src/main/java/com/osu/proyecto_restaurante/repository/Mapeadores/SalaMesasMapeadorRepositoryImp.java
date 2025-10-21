package com.osu.proyecto_restaurante.repository.Mapeadores;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.osu.proyecto_restaurante.domain.entityDomain.Mesas.SalaMesasEntityDomain;
import com.osu.proyecto_restaurante.entitys.SalaMesasEntity;
import com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces.SalaMesasMaperRepository;

@Repository
public class SalaMesasMapeadorRepositoryImp implements SalaMesasMaperRepository{

    @Override
    public SalaMesasEntity convertirAEntidad(SalaMesasEntityDomain salaMesasEntityDomain) {
        SalaMesasEntity salaMesasEntity = new SalaMesasEntity();
        salaMesasEntity.setId_sala(salaMesasEntityDomain.getId_sala());
        salaMesasEntity.setNombre_sala(salaMesasEntityDomain.getNombre_sala());
        return salaMesasEntity;
    }

    @Override
    public SalaMesasEntityDomain convertirADominio(SalaMesasEntity salaMesasEntity) {
        SalaMesasEntityDomain salaMesasEntityDomain = new SalaMesasEntityDomain();
        salaMesasEntityDomain.setId_sala(salaMesasEntity.getId_sala());
        salaMesasEntityDomain.setNombre_sala(salaMesasEntity.getNombre_sala());
        return salaMesasEntityDomain;
    }

    @Override
    public List<SalaMesasEntityDomain> convertirListADominio(List<SalaMesasEntity> listaSalaMesasEntity) {
        if (listaSalaMesasEntity == null) return List.of();
        return listaSalaMesasEntity.stream()
                .map(this::convertirADominio)
                .collect(Collectors.toList());
    }

}
