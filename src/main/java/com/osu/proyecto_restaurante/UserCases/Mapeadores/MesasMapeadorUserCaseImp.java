package com.osu.proyecto_restaurante.UserCases.Mapeadores;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.osu.proyecto_restaurante.UserCases.Mapeadores.Interfaces.MesasMapeadorUserCase;
import com.osu.proyecto_restaurante.domain.entityDomain.Mesas.MesasEntityDomain;
import com.osu.proyecto_restaurante.domain.entityDomain.Mesas.SalaMesasEntityDomain;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.MesaEntradaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.SalaMesaEntradaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.MesasSalidaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.SalaMesasSalidaDTO;

@Repository
public class MesasMapeadorUserCaseImp implements MesasMapeadorUserCase{

    //Mesas DTOs
    @Override
    public MesasEntityDomain convertirADominio(MesaEntradaDTO mesaEntradaDTO) {
        MesasEntityDomain mesasEntityDomain = new MesasEntityDomain();
        mesasEntityDomain.setId_mesa(mesaEntradaDTO.getId_mesa());
        mesasEntityDomain.setNumero_mesa(mesaEntradaDTO.getNumero_mesa());
        mesasEntityDomain.setEstado_mesa(mesaEntradaDTO.isEstado_mesa());
        mesasEntityDomain.setId_sala(mesaEntradaDTO.getId_sala());
        return mesasEntityDomain;  
    }

    @Override
    public MesasSalidaDTO convertirADTO(MesasEntityDomain mesasEntityDomain) {
        MesasSalidaDTO mesasSalidaDTO = new MesasSalidaDTO();
        mesasSalidaDTO.setId_mesa(mesasEntityDomain.getId_mesa());
        mesasSalidaDTO.setNumero_mesa(mesasEntityDomain.getNumero_mesa());
        mesasSalidaDTO.setEstado_mesa(mesasEntityDomain.isEstado_mesa());
        mesasSalidaDTO.setId_sala(mesasEntityDomain.getId_sala());      
        return mesasSalidaDTO;
    }

    @Override
    public List<MesasSalidaDTO> convertirListADTO(List<MesasEntityDomain> listaMesasEntityDomain) {
        if (listaMesasEntityDomain == null) return List.of();
        return listaMesasEntityDomain.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    //Sala Mesas DTOs
    @Override
    public SalaMesasEntityDomain convertirADomainSala(SalaMesaEntradaDTO salaMesasEntradaDTO) {
        SalaMesasEntityDomain salaMesasEntityDomain = new SalaMesasEntityDomain();
        salaMesasEntityDomain.setId_sala(salaMesasEntradaDTO.getId_sala());
        salaMesasEntityDomain.setNombre_sala(salaMesasEntradaDTO.getNombre_sala());
        return salaMesasEntityDomain;   
    }

    @Override
    public SalaMesasSalidaDTO convertirADTOSala(SalaMesasEntityDomain salaMesasEntityDomain) {
        SalaMesasSalidaDTO salaMesasSalidaDTO = new SalaMesasSalidaDTO();
        salaMesasSalidaDTO.setId_sala(salaMesasEntityDomain.getId_sala());
        salaMesasSalidaDTO.setNombre_sala(salaMesasEntityDomain.getNombre_sala());
        return salaMesasSalidaDTO;
    }

    @Override
    public List<SalaMesasSalidaDTO> convertirListADTOSala(List<SalaMesasEntityDomain> listaSalaMesasEntityDomain) {
        if (listaSalaMesasEntityDomain == null) return List.of();
        return listaSalaMesasEntityDomain.stream()
                .map(this::convertirADTOSala)
                .collect(Collectors.toList());
    }

}
