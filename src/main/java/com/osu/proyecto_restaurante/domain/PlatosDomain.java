package com.osu.proyecto_restaurante.domain;

import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Platos.PlatosEntityDomain;

public interface PlatosDomain {
    public boolean InsertarPlato(PlatosEntityDomain platosEntityDomain);
    public boolean ActualizarPlato(PlatosEntityDomain platosEntityDomain);
    public boolean EliminarPlato(int id_plato);
    public PlatosEntityDomain ObtenerPlato(String nombre_plato);
    public List<PlatosEntityDomain> ObtenerPlatos();
}
