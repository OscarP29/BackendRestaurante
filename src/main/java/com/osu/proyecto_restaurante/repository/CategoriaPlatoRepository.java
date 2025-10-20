package com.osu.proyecto_restaurante.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.osu.proyecto_restaurante.domain.CategoriaPlatoDomain;
import com.osu.proyecto_restaurante.domain.entityDomain.Platos.CategoriaPlatoEntityDomain;
import com.osu.proyecto_restaurante.entitys.CategoriaPlatoEntity;
import com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces.CategoriaPlatoMaperRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class CategoriaPlatoRepository implements CategoriaPlatoDomain {
    private final CategoriaPlatoMaperRepository categoriaPlatoMaperRepository;
    private final JdbcTemplate jdbcTemplate;

     private CategoriaPlatoEntity mapeadorCategoriaPlatoEntity(ResultSet rs, int rowNum) throws SQLException {
        CategoriaPlatoEntity categoriaPlatoEntity = new CategoriaPlatoEntity();
        categoriaPlatoEntity.setId_categoria(rs.getInt("id_categoria"));
        categoriaPlatoEntity.setTipo_categoria(rs.getString("tipo_categoria"));
        return categoriaPlatoEntity;
    }
    private final RowMapper<CategoriaPlatoEntity> categoriaPlatoMapper = this::mapeadorCategoriaPlatoEntity;

    @Override
    public void InsertarCategoria(CategoriaPlatoEntityDomain categoriaEntityDomain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'InsertarCategoria'");
    }

    @Override
    public void ActualizarCategoria(CategoriaPlatoEntityDomain categoriaEntityDomain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ActualizarCategoria'");
    }

    @Override
    public void EliminarCategoria(int id_categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'EliminarCategoria'");
    }

    @Override
    public List<CategoriaPlatoEntityDomain> ObtenerCategorias() {
        String sql = "Select id_categoria, tipo_categoria From categoria_plato";
        List<CategoriaPlatoEntity> categoriaPlatoEntities = jdbcTemplate.query(sql, categoriaPlatoMapper);
        return categoriaPlatoMaperRepository.convertirListADominio(categoriaPlatoEntities);
    }

    @Override
    public String ObtenerNombre(int id_categoria) {
        try{
            String sql = "Select id_categoria, tipo_categoria from categoria_plato Where id_categoria = ?";
            CategoriaPlatoEntity categoriaPlatoEntity = jdbcTemplate.queryForObject(sql, categoriaPlatoMapper, id_categoria);
            return categoriaPlatoEntity.getTipo_categoria();
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public int ObtenerId(String tipo_categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ObtenerId'");
    }

}
