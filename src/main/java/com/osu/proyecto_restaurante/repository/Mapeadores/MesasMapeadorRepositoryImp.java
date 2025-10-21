package com.osu.proyecto_restaurante.repository.Mapeadores;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.osu.proyecto_restaurante.domain.entityDomain.Mesas.MesasEntityDomain;
import com.osu.proyecto_restaurante.entitys.MesaEntity;
import com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces.MesasMaperRepositoty;

@Repository
public class MesasMapeadorRepositoryImp implements MesasMaperRepositoty {

    @Override
    public MesaEntity convertirAEntidad(MesasEntityDomain mesasEntityDomain) {
        MesaEntity mesaEntity = new MesaEntity();
        mesaEntity.setId_mesa(mesasEntityDomain.getId_mesa());
        mesaEntity.setNumero_mesa(mesasEntityDomain.getNumero_mesa());
        mesaEntity.setEstado_mesa(mesasEntityDomain.isEstado_mesa());
        mesaEntity.setId_sala(mesasEntityDomain.getId_sala());
        return mesaEntity;
    }

    @Override
    public MesasEntityDomain convertirADominio(MesaEntity mesaEntity) {
        MesasEntityDomain mesasEntityDomain = new MesasEntityDomain();
        mesasEntityDomain.setId_mesa(mesaEntity.getId_mesa());
        mesasEntityDomain.setNumero_mesa(mesaEntity.getNumero_mesa());
        mesasEntityDomain.setEstado_mesa(mesaEntity.isEstado_mesa());
        mesasEntityDomain.setId_sala(mesaEntity.getId_sala());
        return mesasEntityDomain;
    }

    @Override
    public List<MesasEntityDomain> convertirListADominio(List<MesaEntity> listaMesasEntity) {
        if (listaMesasEntity == null) return List.of();
        return listaMesasEntity.stream()
                .map(this::convertirADominio)
                .collect(Collectors.toList());
    }

}
