package com.osu.proyecto_restaurante.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.osu.proyecto_restaurante.domain.SalaMesasDomain;
import com.osu.proyecto_restaurante.domain.entityDomain.Mesas.SalaMesasEntityDomain;
import com.osu.proyecto_restaurante.entitys.SalaMesasEntity;
import com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces.SalaMesasMaperRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class SalaMesasRepositoy implements SalaMesasDomain{

    private final SalaMesasMaperRepository salaMesasMaperRepository;
    private final JdbcTemplate jdbcTemplate;

    private final SalaMesasEntity mapperSalas(ResultSet rs, int rowNum) throws SQLException{
        SalaMesasEntity salaMesasEntity = new SalaMesasEntity();
        salaMesasEntity.setId_sala(rs.getInt("id_sala"));
        salaMesasEntity.setNombre_sala(rs.getString("nombre_sala"));
        return salaMesasEntity;
    }

    private final RowMapper<SalaMesasEntity> salaRowMapper = this::mapperSalas;

    @Override
    public boolean InsertarSalaMesas(SalaMesasEntityDomain salaMesasEntityDomain) {
        String sql = "Insert into salas_mesas (nombre_sala) values (?);";
        SalaMesasEntity salaMesasEntity = salaMesasMaperRepository.convertirAEntidad(salaMesasEntityDomain);
        int filas = jdbcTemplate.update(sql, salaMesasEntity.getNombre_sala());
        return filas > 0;
    }

    @Override
    public boolean EditarSalaMesas(SalaMesasEntityDomain salaMesasEntityDomain) {
        String sql = "Update salas_mesas set nombre_sala = ? where id_sala = ?;";
        SalaMesasEntity salaMesasEntity = salaMesasMaperRepository.convertirAEntidad(salaMesasEntityDomain);
        int filas = jdbcTemplate.update(sql, salaMesasEntity.getNombre_sala(), salaMesasEntity.getId_sala());
        return filas > 0;
    }

    @Override
    public boolean EliminarSalaMesas(int id_sala) {
        String sql = "Delete from salas_mesas where id_sala = ?;";
        int filas = jdbcTemplate.update(sql, id_sala);
        return filas > 0;
    }

    @Override
    public List<SalaMesasEntityDomain> ObtenerSalaMesas() {
        String sql = "Select id_sala, nombre_sala from salas_mesas;";
        List<SalaMesasEntity> salaMesasEntities = jdbcTemplate.query(sql, salaRowMapper);
        return salaMesasMaperRepository.convertirListADominio(salaMesasEntities);
    }

    @Override
    public String ObtenerNombreSala(int id_sala) {
        String sql = "Select nombre_sala, id_sala from salas_mesas where id_sala = ?;";
        SalaMesasEntity salaMesasEntity = jdbcTemplate.queryForObject(sql, salaRowMapper, id_sala);
        return salaMesasEntity.getNombre_sala();
    }

    @Override
    public int ObtenerIdSala(String nombre_sala) {
        String sql = "Select id_sala, nombre_sala from salas_mesas where nombre_sala = ?;";
        SalaMesasEntity salaMesasEntity = jdbcTemplate.queryForObject(sql, salaRowMapper, nombre_sala);
        return salaMesasEntity.getId_sala();
    }

    
}
