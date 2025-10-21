package com.osu.proyecto_restaurante.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.osu.proyecto_restaurante.domain.MesasDomain;
import com.osu.proyecto_restaurante.domain.entityDomain.Mesas.MesasEntityDomain;
import com.osu.proyecto_restaurante.entitys.MesaEntity;
import com.osu.proyecto_restaurante.repository.Mapeadores.Interfaces.MesasMaperRepositoty;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MesasRepository implements MesasDomain {

    private final MesasMaperRepositoty mesasMaperRepositoty;
    private final JdbcTemplate jdbcTemplate;

    private MesaEntity maperMesas(ResultSet rs, int rowNum) throws SQLException{
        MesaEntity mesaEntity = new MesaEntity();
        mesaEntity.setId_mesa(rs.getInt("id_mesas"));
        mesaEntity.setNumero_mesa(rs.getInt("numero_mesa"));
        mesaEntity.setEstado_mesa(rs.getBoolean("estado_mesa"));
        mesaEntity.setId_sala(rs.getInt("id_sala"));
        return mesaEntity;
    }
    private final RowMapper<MesaEntity> mesaRowMapper = this::maperMesas;

    @Override
    public boolean InsertarMesa(MesasEntityDomain mesasEntityDomain) {
        String sql = "Insert into mesas (numero_mesa, estado_mesa, id_sala) values (?, ?, ?)";
        MesaEntity mesaEntity = mesasMaperRepositoty.convertirAEntidad(mesasEntityDomain);
        int filas = jdbcTemplate.update(sql, mesaEntity.getNumero_mesa(), mesaEntity.isEstado_mesa(), mesaEntity.getId_sala());
        return filas > 0;
    }

    @Override
    public boolean EditarMesa(MesasEntityDomain mesasEntityDomain) {
        String sql = "Update mesas set numero_mesa = ?, id_sala = ? where id_mesas = ?";
        MesaEntity mesaEntity = mesasMaperRepositoty.convertirAEntidad(mesasEntityDomain);
        int filas = jdbcTemplate.update(sql, mesaEntity.getNumero_mesa(), mesaEntity.getId_sala(), mesaEntity.getId_mesa());
        return filas > 0;
    }

    @Override
    public boolean EliminarMesa(int id_mesa) {
        String sql = "Delete from mesas where id_mesas = ?";
        int filas = jdbcTemplate.update(sql, id_mesa);
        return filas > 0;
    }

    @Override
    public List<MesasEntityDomain> ObtenerMesas() {
        String sql = "Select id_mesas, numero_mesa, estado_mesa, id_sala from mesas";
        List<MesaEntity> mesasEntity = jdbcTemplate.query(sql, mesaRowMapper);
        return mesasMaperRepositoty.convertirListADominio(mesasEntity);
    }

    @Override
    public boolean CambiarEstadoMesa(int id_mesa, boolean estado_mesa) {
        String sql = "Update mesas set estado_mesa = ? where id_mesas = ?";
        int filas = jdbcTemplate.update(sql, estado_mesa, id_mesa);
        return filas > 0;
    }

}
