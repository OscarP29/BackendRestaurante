package com.osu.proyecto_restaurante.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.osu.proyecto_restaurante.domain.PlatosDomain;
import com.osu.proyecto_restaurante.domain.entityDomain.Platos.PlatosEntityDomain;
import com.osu.proyecto_restaurante.entitys.PlatoEntity;
import com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces.PlatoMaperRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class PlatosRepository implements PlatosDomain{

    private final PlatoMaperRepository platoMaperRepository;
    private final JdbcTemplate jdbcTemplate;

    private PlatoEntity mapeadorPlatoEntity(ResultSet rs, int rowNum) throws SQLException {
        PlatoEntity platoEntity = new PlatoEntity();
        platoEntity.setId_plato(rs.getInt("id_plato"));
        platoEntity.setNombre_plato(rs.getString("nombre_plato"));
        platoEntity.setDescripcion_plato(rs.getString("descripcion_plato"));
        platoEntity.setId_categoria(rs.getInt("id_categoria"));
        platoEntity.setPrecio_plato(rs.getInt("precio_plato"));
        return platoEntity;
    }

    private final RowMapper<PlatoEntity> platoMapper = this::mapeadorPlatoEntity;
    @Override
    public void InsertarPlato(com.osu.proyecto_restaurante.domain.entityDomain.Platos.PlatosEntityDomain platosEntityDomain, int id_categoria) {
        String sql = "insert into plato(descripcion_plato,nombre_plato,id_categoria,precio_plato) values(?,?,?,?);";
        PlatoEntity platoEntity = platoMaperRepository.convertirAEntidad(platosEntityDomain, id_categoria);
        jdbcTemplate.update(sql, platoEntity.getDescripcion_plato(), platoEntity.getNombre_plato(), platoEntity.getId_categoria(), platoEntity.getPrecio_plato());
    }

    @Override
    public void ActualizarPlato(com.osu.proyecto_restaurante.domain.entityDomain.Platos.PlatosEntityDomain platosEntityDomain) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void EliminarPlato(com.osu.proyecto_restaurante.domain.entityDomain.Platos.PlatosEntityDomain platosEntityDomain) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public PlatosEntityDomain ObtenerPlato(String nombre_plato) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ObtenerPlato'");
    }
    @Override
    public List<PlatosEntityDomain> ObtenerPlatos() {
        String sql = "Select id_plato, nombre_plato, descripcion_plato, id_categoria, precio_plato From plato";
        List<PlatoEntity> platoEntities = jdbcTemplate.query(sql, platoMapper);
        return platoMaperRepository.convertirListADominio(platoEntities);
    }

}
