package com.chn.examen.service;

import com.chn.examen.model.Cliente;

import java.util.List;

public interface iClienteService {
    public List<Cliente> findAll();
    public int save(Cliente cliente);
    public int update(Cliente cliente);
    public int deleteBy(int id);
}
