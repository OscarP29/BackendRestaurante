package com.osu.proyecto_restaurante.entitys;

import lombok.Data;

@Data
public class UsuarioEntity {
    private int id_usuario;
    private String apellido_usuario;
    private String contrasena_usuario;
    private String nombre_usuario;
    private String user_usuario;
    private int id_tipo_usuario;
}
