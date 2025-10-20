package com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces;

import com.osu.proyecto_restaurante.domain.entityDomain.UsuarioEntityDomain;
import com.osu.proyecto_restaurante.entitys.TipoUsuarioEntity;
import com.osu.proyecto_restaurante.entitys.UsuarioEntity;

public interface UsuarioMaperRepositoy {
    public UsuarioEntityDomain convertirADominio(UsuarioEntity usuarioEntity, TipoUsuarioEntity tipoUsuarioEntity);
}
