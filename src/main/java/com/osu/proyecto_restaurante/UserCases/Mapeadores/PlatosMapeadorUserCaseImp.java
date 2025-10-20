package com.osu.proyecto_restaurante.UserCases.Mapeadores;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.osu.proyecto_restaurante.UserCases.Mapeadores.Interfaces.PlatosMapeadorUserCase;
import com.osu.proyecto_restaurante.domain.entityDomain.Platos.CategoriaPlatoEntityDomain;
import com.osu.proyecto_restaurante.domain.entityDomain.Platos.PlatosEntityDomain;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.PlatoEntradaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.CategoriasPlatoSalidaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.PlatosSalidaDTO;

@Repository
public class PlatosMapeadorUserCaseImp implements PlatosMapeadorUserCase {

    @Override
    public PlatosSalidaDTO convertirDTO(PlatosEntityDomain platosEntityDomain, String tipo_categoria) {
        PlatosSalidaDTO platosSalidaDTO = new PlatosSalidaDTO();
        platosSalidaDTO.setId_plato(platosEntityDomain.getId_plato());
        platosSalidaDTO.setNombre_plato(platosEntityDomain.getNombre_plato());
        platosSalidaDTO.setDescripcion_plato(platosEntityDomain.getDescripcion_plato());
        platosSalidaDTO.setPrecio_plato(platosEntityDomain.getPrecio_plato());
        platosSalidaDTO.setTipo_categoria(tipo_categoria);
        return platosSalidaDTO;
    }

    @Override
    public CategoriasPlatoSalidaDTO convertirCategoriaDTO(CategoriaPlatoEntityDomain categoriaPlatoEntityDomain) {
        CategoriasPlatoSalidaDTO categoriasPlatoSalidaDTO = new CategoriasPlatoSalidaDTO();
        categoriasPlatoSalidaDTO.setId_categoria(categoriaPlatoEntityDomain.getId_categoria());
        categoriasPlatoSalidaDTO.setTipo_categoria(categoriaPlatoEntityDomain.getTipo_categoria());
        return categoriasPlatoSalidaDTO;
    }

    @Override
    public List<CategoriasPlatoSalidaDTO> convertirListCategoriaDTO(List<CategoriaPlatoEntityDomain> categoriaPlatoEntityDomains) {
         if (categoriaPlatoEntityDomains == null) return List.of();
        return categoriaPlatoEntityDomains.stream()
                .map(this::convertirCategoriaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlatosEntityDomain convertirADominio(PlatoEntradaDTO platoEntradaDTO,int id_categoria) {
        PlatosEntityDomain platosEntityDomain = new PlatosEntityDomain();
        platosEntityDomain.setId_plato(platoEntradaDTO.getId_plato());
        platosEntityDomain.setNombre_plato(platoEntradaDTO.getNombre_plato());
        platosEntityDomain.setDescripcion_plato(platoEntradaDTO.getDescripcion_plato());
        platosEntityDomain.setId_categoria(id_categoria);
        platosEntityDomain.setPrecio_plato(platoEntradaDTO.getPrecio_plato());
        return platosEntityDomain;
    }


    

}
