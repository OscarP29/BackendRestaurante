package com.osu.proyecto_restaurante.repository;

import com.osu.proyecto_restaurante.domain.UsuarioDomain;
import com.osu.proyecto_restaurante.domain.entityDomain.UsuarioEntityDomain;
import com.osu.proyecto_restaurante.entitys.TipoUsuarioEntity;
import com.osu.proyecto_restaurante.entitys.UsuarioEntity;
import com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces.UsuarioMaperRepositoy;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
@AllArgsConstructor
public class UsuarioRepository implements UsuarioDomain {
    private final UsuarioMaperRepositoy usuarioMaperRepositoy;
    private final JdbcTemplate jdbcTemplate;

    //Funcion que convierte cada fila de una consulta en un objeto
    private UsuarioEntity mapeadorUsuarioEntity(ResultSet rs, int rowNum) throws SQLException {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId_usuario(rs.getInt("id_usuario"));
        usuarioEntity.setNombre_usuario(rs.getString("nombre_usuario"));
        usuarioEntity.setApellido_usuario(rs.getString("apellido_usuario"));
        usuarioEntity.setUser_usuario(rs.getString("user_usuario"));
        usuarioEntity.setContrasena_usuario(rs.getString("contrasena_usuario"));
        usuarioEntity.setId_tipo_usuario(rs.getInt("id_tipo_usuario"));
        return usuarioEntity;
    }
    private TipoUsuarioEntity mapeadorTipoUsuarioEntity(ResultSet rs, int rowNum) throws SQLException {
        TipoUsuarioEntity tipoUsuarioEntity = new TipoUsuarioEntity();
        tipoUsuarioEntity.setId_tipo_usuario(rs.getInt("id_tipo_usuario"));
        tipoUsuarioEntity.setTipo_usuario(rs.getString("tipo_usuario"));
        return tipoUsuarioEntity;
    }
    
    private final RowMapper<UsuarioEntity> usuarioMapper = this::mapeadorUsuarioEntity;
    private final RowMapper<TipoUsuarioEntity> tipoUsuarioMapper = this::mapeadorTipoUsuarioEntity;

    @Override
    public UsuarioEntityDomain buscarPorUser(String user) {
        try{
            String sql = "Select id_usuario, nombre_usuario, apellido_usuario, user_usuario , contrasena_usuario, id_tipo_usuario From usuario Where user_usuario = ?";
            UsuarioEntity usuarios = jdbcTemplate.queryForObject(sql, usuarioMapper, user); 
            String sqlTipoUsuario = "Select tipo_usuario, id_tipo_usuario from tipo_usuario Where id_tipo_usuario = ?";
            TipoUsuarioEntity tipoUsuario = jdbcTemplate.queryForObject(sqlTipoUsuario, tipoUsuarioMapper, usuarios.getId_tipo_usuario());
            return usuarioMaperRepositoy.convertirADominio(usuarios, tipoUsuario);
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public boolean validarLogin(String user, String contrasena) {
        UsuarioEntityDomain usuario = buscarPorUser(user);
        if (usuario != null && usuario.getContrasena_usuario().equals(contrasena)) {
            return true;
        }
        return false;
    }
}
