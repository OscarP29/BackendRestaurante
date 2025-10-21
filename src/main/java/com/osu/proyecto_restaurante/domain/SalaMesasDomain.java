package com.osu.proyecto_restaurante.domain;

import java.util.List;

import com.osu.proyecto_restaurante.domain.entityDomain.Mesas.SalaMesasEntityDomain;

public interface SalaMesasDomain {
    public boolean InsertarSalaMesas(SalaMesasEntityDomain salaMesasEntityDomain);
    public boolean EditarSalaMesas(SalaMesasEntityDomain salaMesasEntityDomain);
    public boolean EliminarSalaMesas(int id_sala);
    public List<SalaMesasEntityDomain> ObtenerSalaMesas();
    public String ObtenerNombreSala(int id_sala);
    public int ObtenerIdSala(String nombre_sala); 
}
