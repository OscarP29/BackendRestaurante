package com.osu.proyecto_restaurante.domain;

import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Platos.CategoriaPlatoEntityDomain;

public interface CategoriaPlatoDomain {
    public boolean InsertarCategoria(CategoriaPlatoEntityDomain categoriaEntityDomain);
    public boolean ActualizarCategoria(CategoriaPlatoEntityDomain categoriaEntityDomain);
    public boolean EliminarCategoria(int id_categoria);
    public List<CategoriaPlatoEntityDomain> ObtenerCategorias();
    public String ObtenerNombre(int id_categoria);
    public int ObtenerId(String tipo_categoria);
}
