package com.osu.proyecto_restaurante.UserCases;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.osu.proyecto_restaurante.UserCases.Mapeadores.Interfaces.PlatosMapeadorUserCase;
import com.osu.proyecto_restaurante.domain.CategoriaPlatoDomain;
import com.osu.proyecto_restaurante.domain.PlatosDomain;
import com.osu.proyecto_restaurante.domain.entityDomain.Platos.PlatosEntityDomain;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.CategoriaPlatoEntradaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.PlatoEntradaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.CategoriasPlatoSalidaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.PlatosSalidaDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlatosUserCases {

    private final PlatosMapeadorUserCase platosMapeadorUserCase;

    private final PlatosDomain platosDomain;
    private final CategoriaPlatoDomain categoriaPlatoDomain;

    //Platos Funciones CRUD
    public List<PlatosSalidaDTO> obtenerPlatos() {
        List<PlatosEntityDomain> listaPLatos = platosDomain.ObtenerPlatos();
        List<PlatosSalidaDTO> listaPlatosDTO = new ArrayList<>();
        for(int i = 0; i < listaPLatos.size(); i++) {
            String nombreCategoria = categoriaPlatoDomain.ObtenerNombre(listaPLatos.get(i).getId_categoria());
            PlatosSalidaDTO plato = platosMapeadorUserCase.convertirDTO(listaPLatos.get(i), nombreCategoria);    
            listaPlatosDTO.add(plato);
        }
        return listaPlatosDTO;
    }
    public boolean insertarPlato(PlatoEntradaDTO platoEntradaDTO) {
        int id_categoria = categoriaPlatoDomain.ObtenerId(platoEntradaDTO.getCategoria_plato());
        return platosDomain.InsertarPlato(platosMapeadorUserCase.convertirADominio(platoEntradaDTO, id_categoria));
    }
    public boolean actualizarPlato(PlatoEntradaDTO platoEntradaDTO) {
        int id_categoria = categoriaPlatoDomain.ObtenerId(platoEntradaDTO.getCategoria_plato());
        return platosDomain.ActualizarPlato(platosMapeadorUserCase.convertirADominio(platoEntradaDTO, id_categoria));
    }
    public boolean eliminarPlato(int id_plato) {
        return platosDomain.EliminarPlato(id_plato);
    }

    //CategoriaPlato Funciones CRUD
    public List<CategoriasPlatoSalidaDTO> obtenerCategorias(){
        return platosMapeadorUserCase.convertirListCategoriaDTO(categoriaPlatoDomain.ObtenerCategorias());
    }
    public boolean insertarCategoria(CategoriaPlatoEntradaDTO categoriaPlatoEntradaDTO) {
        return categoriaPlatoDomain.InsertarCategoria(platosMapeadorUserCase.convertirCategoriaADominio(categoriaPlatoEntradaDTO));
    }
    public boolean actualizarCategoria(CategoriaPlatoEntradaDTO categoriaPlatoEntradaDTO) {
        return categoriaPlatoDomain.ActualizarCategoria(platosMapeadorUserCase.convertirCategoriaADominio(categoriaPlatoEntradaDTO));
    }
    public boolean eliminarCategoria(int id_categoria) {
        return categoriaPlatoDomain.EliminarCategoria(id_categoria);
    }
}
