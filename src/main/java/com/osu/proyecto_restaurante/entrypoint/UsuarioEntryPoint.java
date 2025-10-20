package com.osu.proyecto_restaurante.entrypoint;

import org.springframework.web.bind.annotation.RestController;

import com.osu.proyecto_restaurante.UserCases.PlatosUserCases;
import com.osu.proyecto_restaurante.domain.UsuarioDomain;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.CategoriaPlatoEntradaDTO;
import com.osu.proyecto_restaurante.entrypoint.DTOs.Entrada.PlatoEntradaDTO;
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
    //Method CRUD Platos
    @GetMapping("/Platos")
    public List<PlatosSalidaDTO> ObtenerPlatos() {
        return platosUserCases.obtenerPlatos() ;
    }
    @PostMapping("/PlatosInsertar")
    public ResponseEntity<?> InsertarPlato(@RequestBody PlatoEntradaDTO plato) {
        boolean resultado = platosUserCases.insertarPlato(plato);
        if (resultado){
            return ResponseEntity.ok(Map.of("insertado", true));
        } else {
            return ResponseEntity.status(400).body(Map.of("insertado", false, "message", "Error al insertar el plato"));
        }
    }
    @PostMapping("/PlatosActualizar")
    public ResponseEntity<?> ActualizarPlato(@RequestBody PlatoEntradaDTO plato) {
        boolean resultado = platosUserCases.actualizarPlato(plato);
        if (resultado){
            return ResponseEntity.ok(Map.of("actualizado", true));
        } else {
            return ResponseEntity.status(400).body(Map.of("actualizado", false, "message", "Error al actualizar el plato"));
        }
    }
    @PostMapping("/PlatosEliminar")
    public ResponseEntity<?> EliminarPlato(@RequestBody PlatoEntradaDTO plato) {
        boolean resultado = platosUserCases.eliminarPlato(plato.getId_plato());
        if (resultado){
            return ResponseEntity.ok(Map.of("eliminado", true));
        } else {
            return ResponseEntity.status(400).body(Map.of("eliminado", false, "message", "Error al eliminar el plato"));
        }
        
    }
    //Method CRUD CategoriaPlato
    @GetMapping("/Categorias")
    public List<CategoriasPlatoSalidaDTO> ObtenerCategorias() {
        return platosUserCases.obtenerCategorias();
    }
    @PostMapping("/CategoriasInsertar")
    public ResponseEntity<?> InsertarCategoria(@RequestBody CategoriaPlatoEntradaDTO categoria) {
        boolean resultado = platosUserCases.insertarCategoria(categoria);
        if (resultado){
            return ResponseEntity.ok(Map.of("insertado", true));
        } else {
            return ResponseEntity.status(400).body(Map.of("insertado", false, "message", "Error al insertar la categoria"));
        }
    }
    @PostMapping("/CategoriasActualizar")
    public ResponseEntity<?> ActualizarCategoria(@RequestBody CategoriaPlatoEntradaDTO categoria) {
        boolean resultado = platosUserCases.actualizarCategoria(categoria);
        if (resultado){
            return ResponseEntity.ok(Map.of("actualizado", true));
        } else {
            return ResponseEntity.status(400).body(Map.of("actualizado", false, "message", "Error al actualizar la categoria"));
        }
    }
    @PostMapping("/CategoriasEliminar")
    public ResponseEntity<?> EliminarCategoria(@RequestBody CategoriaPlatoEntradaDTO categoria) {   
        boolean resultado = platosUserCases.eliminarCategoria(categoria.getId_categoria());
        if (resultado){
            return ResponseEntity.ok(Map.of("eliminado", true));
        } else {
            return ResponseEntity.status(400).body(Map.of("eliminado", false, "message", "Error al eliminar la categoria"));
        }
        
    }
}
