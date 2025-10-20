package com.osu.proyecto_restaurante.UserCases.Mapeadores.Interfaces;


import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Platos.CategoriaPlatoEntityDomain;
import com.osu.proyecto_restaurante.domain.entityDomain.Platos.PlatosEntityDomain;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.CategoriaPlatoEntradaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.PlatoEntradaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.CategoriasPlatoSalidaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.PlatosSalidaDTO;

public interface PlatosMapeadorUserCase {
    //PlatosSalidaDTO Y PlatosEntradDTO
    public PlatosSalidaDTO convertirDTO(PlatosEntityDomain platosEntityDomain, String tipo_categoria);
    public PlatosEntityDomain convertirADominio(PlatoEntradaDTO platoEntradaDTO,int id_categoria);

    //CategoriaPlatoSalidaDTO Y CategoriaPlatoEntradaDTO
    public CategoriasPlatoSalidaDTO convertirCategoriaDTO(CategoriaPlatoEntityDomain categoriaPlatoEntityDomain);
    public CategoriaPlatoEntityDomain convertirCategoriaADominio(CategoriaPlatoEntradaDTO categoriaPlatoEntradaDTO);
    public List<CategoriasPlatoSalidaDTO> convertirListCategoriaDTO(List<CategoriaPlatoEntityDomain> categoriaPlatoEntityDomains);
}
