package com.chn.examen.repository;

import com.chn.examen.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository implements iClienteRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Cliente> findAll() {
        String sql = "SELECT * FROM Cliente Where Estado=1";
        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Cliente.class));
    }

    @Override
    public int save(Cliente cliente) {
        String sql = "INSERT INTO Cliente VALUES(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{cliente.getNombre(),cliente.getApellido(),
                cliente.getNumero_identificacion(),cliente.getFecha_nacimiento(),cliente.getDireccion(),
        cliente.getCorreo_electronico(),cliente.getTelefono(),cliente.isEstado()});
    }

    @Override
    public int update(Cliente cliente) {
        String sql = "UPDATE Cliente set Nombre=? , Apellido=?, Numero_identificacion=?, Fecha_Nacimiento=?" +
                ", Direccion=?, Correo_Electronico=?, Telefono=?, Estado=? WHERE Id_Cliente=?";
        return jdbcTemplate.update(sql, new Object[]{cliente.getNombre(),cliente.getApellido(),
                cliente.getNumero_identificacion(),cliente.getFecha_nacimiento(),cliente.getDireccion(),
                cliente.getCorreo_electronico(),cliente.getTelefono(),cliente.isEstado(),cliente.getId_cliente()});
    }

    @Override
    public int deleteBy(int id) {
        String sql = "UPDATE Cliente set Estado=0 WHERE Id_Cliente=?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }

}

