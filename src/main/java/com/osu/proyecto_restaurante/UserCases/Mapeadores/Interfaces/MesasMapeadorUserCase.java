package com.osu.proyecto_restaurante.UserCases.Mapeadores.Interfaces;

import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Mesas.MesasEntityDomain;
import com.osu.proyecto_restaurante.domain.entityDomain.Mesas.SalaMesasEntityDomain;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.MesaEntradaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.SalaMesaEntradaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.MesasSalidaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.SalaMesasSalidaDTO;

public interface MesasMapeadorUserCase {
    //Mesas DTOs
    public MesasEntityDomain convertirADominio(MesaEntradaDTO mesaEntradaDTO);
    public MesasSalidaDTO convertirADTO(MesasEntityDomain mesasEntityDomain);
    public List<MesasSalidaDTO> convertirListADTO(List<MesasEntityDomain> listaMesasEntityDomain);

    //Sala Mesas DTOs
    public SalaMesasEntityDomain convertirADomainSala(SalaMesaEntradaDTO salaMesasEntradaDTO);
    public SalaMesasSalidaDTO convertirADTOSala(SalaMesasEntityDomain salaMesasEntityDomain);
    public List<SalaMesasSalidaDTO> convertirListADTOSala(List<SalaMesasEntityDomain> listaSalaMesasEntityDomain);
}
