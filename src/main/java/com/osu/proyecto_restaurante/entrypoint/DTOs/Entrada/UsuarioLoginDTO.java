package com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada;

import lombok.Data;

@Data
public class UsuarioLoginDTO {
    private String user;
    private String contrasena;
}