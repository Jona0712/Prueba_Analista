package com.chn.examen.repository;

import com.chn.examen.model.ModiChequeEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ModiChequeEstadoRepository implements iModiChequeEstadoRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(ModiChequeEstado modiEstadoCheque) {
        String sql = "INSERT INTO Modificacion_Cheque VALUES(?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{modiEstadoCheque.getMotivo_Actualizacion(),
                modiEstadoCheque.getFecha_Actualizacion(),
                modiEstadoCheque.getId_Cheque()});
    }
}
