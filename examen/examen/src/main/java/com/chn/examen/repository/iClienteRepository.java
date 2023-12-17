package com.chn.examen.repository;

import com.chn.examen.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface iClienteRepository {
    public List<Cliente> findAll();
    public int save(Cliente cliente);
    public int update(Cliente cliente);
    public int deleteBy(int id);

}
