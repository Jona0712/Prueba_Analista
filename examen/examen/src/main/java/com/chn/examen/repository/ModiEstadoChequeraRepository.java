package com.chn.examen.repository;

import com.chn.examen.model.ModiEstadoChequera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ModiEstadoChequeraRepository implements iModiEstadoChequeraRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(ModiEstadoChequera modiEstadoCuenta) {
        String sql = "INSERT INTO Modificacion_Chequera VALUES(?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{modiEstadoCuenta.getMotivo_Actualizacion(),
                modiEstadoCuenta.getFecha_Actualizacion(),
                modiEstadoCuenta.getId_Chequera()});
    }
}
