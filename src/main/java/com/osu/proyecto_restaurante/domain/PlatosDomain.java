package com.osu.proyecto_restaurante.domain;

import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Platos.PlatosEntityDomain;

public interface PlatosDomain {
    public void InsertarPlato(PlatosEntityDomain platosEntityDomain, int id_categoria);
    public void ActualizarPlato(PlatosEntityDomain platosEntityDomain);
    public void EliminarPlato(PlatosEntityDomain platosEntityDomain);
    public PlatosEntityDomain ObtenerPlato(String nombre_plato);
    public List<PlatosEntityDomain> ObtenerPlatos();
}
