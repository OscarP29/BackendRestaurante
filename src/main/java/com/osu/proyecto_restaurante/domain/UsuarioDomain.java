package com.osu.proyecto_restaurante.domain;

import com.osu.proyecto_restaurante.domain.entityDomain.UsuarioEntityDomain;

public interface UsuarioDomain {
   public UsuarioEntityDomain buscarPorUser(String user);
   public boolean validarLogin(String User, String Contrasena);
}
