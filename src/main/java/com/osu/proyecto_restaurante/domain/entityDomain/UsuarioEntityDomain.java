package com.osu.proyecto_restaurante.domain.entityDomain;

import lombok.Data;

@Data
public class UsuarioEntityDomain {
    private String nombre_usuario;
    private String apellido_usuario;
    private String user_usuario;
    private String contrasena_usuario;
    private String tipo_usuario;
}
