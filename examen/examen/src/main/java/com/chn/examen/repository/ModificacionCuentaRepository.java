package com.chn.examen.repository;

import com.chn.examen.model.ModificacionEstadoCuenta;
import com.chn.examen.service.ModificacionCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ModificacionCuentaRepository implements iModiCuentaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(ModificacionEstadoCuenta modificacionEstadoCuenta) {
        String sql = "INSERT INTO Modificacion_Cuenta VALUES(?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{modificacionEstadoCuenta.getMotivo_Actualizacion(),
                modificacionEstadoCuenta.getFecha_Actualizacion(),
                modificacionEstadoCuenta.getId_Cuenta()});
    }
}
