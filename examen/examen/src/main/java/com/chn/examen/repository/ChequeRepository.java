package com.chn.examen.repository;

import com.chn.examen.model.Cheque;
import com.chn.examen.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChequeRepository implements iChequeRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Cheque> findAll(int idChequera) {
        String sql = "SELECT * FROM Cheque  Where  Id_Chequera=?";
        // Utilizando BeanPropertyRowMapper para mapear el resultado a objetos Cuenta
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cheque.class), idChequera);
    }

    @Override
    public int save(Cheque cheque) {
        String sql = "INSERT INTO Cheque VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{cheque.getId_Chequera(),cheque.getId_Estado(),
                cheque.getMonto(),cheque.getFecha_Cheque(),cheque.getCuenta_acreditar()});
    }

    @Override
    public int update(Cheque cheque) {
        String sql = "UPDATE Cheque set  Id_Estado=? WHERE Id_Cheque=?";
        return jdbcTemplate.update(sql, new Object[]{cheque.getId_Estado()
                ,cheque.getId_Cheque()});
    }
}
