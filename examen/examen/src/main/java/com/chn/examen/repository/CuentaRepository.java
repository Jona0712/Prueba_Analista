package com.chn.examen.repository;

import com.chn.examen.model.Cliente;
import com.chn.examen.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CuentaRepository implements iCuentaRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Cuenta> findAll(int cliente) {
        String sql = "SELECT * FROM Cuenta  Where Id_EstadoCuenta=1 and Id_Cliente=?";
        // Utilizando BeanPropertyRowMapper para mapear el resultado a objetos Cuenta
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cuenta.class), cliente);
    }

    @Override
    public int save(Cuenta cuenta) {
        String sql = "INSERT INTO Cuenta VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{cuenta.getId_Cliente(),cuenta.getTipo_Cuenta(),
                cuenta.getMonto(),cuenta.getId_EstadoCuenta()});
    }

    @Override
    public int update(Cuenta cuenta) {
        String sql = "UPDATE Cuenta set Monto=? , Id_EstadoCuenta=? WHERE Id_Cuenta=?";
        return jdbcTemplate.update(sql, new Object[]{cuenta.getMonto(),cuenta.getId_EstadoCuenta()
                ,cuenta.getId_Cuenta()});
    }

    @Override
    public int deleteBy(int id) {
        String sql = "UPDATE Cuenta set Id_EstadoCuenta=3 WHERE Id_Cuenta=? ";
        return jdbcTemplate.update(sql, new Object[]{id});
    }
}
