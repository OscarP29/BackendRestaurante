package com.osu.proyecto_restaurante.domain;

import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Platos.CategoriaPlatoEntityDomain;

public interface CategoriaPlatoDomain {
    public void InsertarCategoria(CategoriaPlatoEntityDomain categoriaEntityDomain);
    public void ActualizarCategoria(CategoriaPlatoEntityDomain categoriaEntityDomain);
    public void EliminarCategoria(int id_categoria);
    public List<CategoriaPlatoEntityDomain> ObtenerCategorias();
    public String ObtenerNombre(int id_categoria);
    public int ObtenerId(String tipo_categoria);
}
