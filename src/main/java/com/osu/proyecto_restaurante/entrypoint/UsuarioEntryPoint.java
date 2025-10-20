package com.osu.proyecto_restaurante.entrypoint;

import org.springframework.web.bind.annotation.RestController;

import com.osu.proyecto_restaurante.UserCases.PlatosUserCases;
import com.osu.proyecto_restaurante.domain.UsuarioDomain;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.UsuarioLoginDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.CategoriasPlatoSalidaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Salida.PlatosSalidaDTO;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@AllArgsConstructor
public class UsuarioEntryPoint {
    private final UsuarioDomain usuarioDomain;
    private final PlatosUserCases platosUserCases;

    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO user) {
        boolean validar = usuarioDomain.validarLogin(user.getUser(), user.getContrasena());
        if (validar) {
            return ResponseEntity.ok(Map.of("login", true));
        }
        return ResponseEntity.status(401).body(Map.of("login", false, "message", "Credenciales invalidas"));
    }
    
    @GetMapping("/Platos")
    public List<PlatosSalidaDTO> ObtenerPlatos() {
        return platosUserCases.obtenerPlatos() ;
    }
    @GetMapping("/Categorias")
    public List<CategoriasPlatoSalidaDTO> ObtenerCategorias() {
        return platosUserCases.obtenerCategorias();
    }

    
}
