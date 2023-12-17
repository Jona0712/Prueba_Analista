package com.chn.examen.repository;

import com.chn.examen.model.Chequera;
import com.chn.examen.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ChequeraRepository implements iChequeraRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Chequera> findAll(int cuenta) {
        String sql = "SELECT * FROM Chequera  Where Id_Estado=1 and Id_Cuenta=?";
        // Utilizando BeanPropertyRowMapper para mapear el resultado a objetos Cuenta
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Chequera.class), cuenta);
    }

    @Override
    public int save(Chequera chequera) {
        String sql = "INSERT INTO Chequera VALUES(?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{chequera.getId_cuenta(),chequera.getCantidad_cheque(),
                chequera.getId_Estado()});
    }

    @Override
    public int update(Chequera chequera) {
            String sql = "UPDATE Chequera set Id_Estado=?  WHERE Id_Chequera=?";
        return jdbcTemplate.update(sql, new Object[]{chequera.getId_Estado(),chequera.getId_Chequera()});
    }
}
