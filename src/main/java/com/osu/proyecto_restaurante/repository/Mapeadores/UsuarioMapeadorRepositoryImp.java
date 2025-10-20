package com.osu.proyecto_restaurante.repository.Mapeadores;


import org.springframework.stereotype.Repository;

import com.osu.proyecto_restaurante.domain.entityDomain.UsuarioEntityDomain;
import com.osu.proyecto_restaurante.entitys.TipoUsuarioEntity;
import com.osu.proyecto_restaurante.entitys.UsuarioEntity;
import com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces.UsuarioMaperRepositoy;

@Repository
public class UsuarioMapeadorRepositoryImp implements UsuarioMaperRepositoy {


    @Override
    public UsuarioEntityDomain convertirADominio(UsuarioEntity usuarioEntity, TipoUsuarioEntity tipoUsuarioEntity) {
        UsuarioEntityDomain usuarioEntityDomain = new UsuarioEntityDomain();
        usuarioEntityDomain.setNombre_usuario(usuarioEntity.getNombre_usuario());
        usuarioEntityDomain.setApellido_usuario(usuarioEntity.getApellido_usuario());
        usuarioEntityDomain.setUser_usuario(usuarioEntity.getUser_usuario());
        usuarioEntityDomain.setContrasena_usuario(usuarioEntity.getContrasena_usuario());
        usuarioEntityDomain.setTipo_usuario(tipoUsuarioEntity.getTipo_usuario());
        return usuarioEntityDomain;
    }

}
