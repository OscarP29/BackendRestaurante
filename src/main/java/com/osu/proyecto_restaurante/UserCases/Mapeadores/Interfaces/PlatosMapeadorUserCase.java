package com.osu.proyecto_restaurante.UserCases.Mapeadores.Interfaces;


import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Platos.CategoriaPlatoEntityDomain;
import com.osu.proyecto_restaurante.domain.entityDomain.Platos.PlatosEntityDomain;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.CategoriasPlatoSalidaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.PlatosSalidaDTO;

public interface PlatosMapeadorUserCase {
    public PlatosSalidaDTO convertirDTO(PlatosEntityDomain platosEntityDomain, String tipo_categoria);
    public CategoriasPlatoSalidaDTO convertirCategoriaDTO(CategoriaPlatoEntityDomain categoriaPlatoEntityDomain);
    public List<CategoriasPlatoSalidaDTO> convertirListCategoriaDTO(List<CategoriaPlatoEntityDomain> categoriaPlatoEntityDomains);
}
