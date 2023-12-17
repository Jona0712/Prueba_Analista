package com.chn.examen.service;

import com.chn.examen.model.Cliente;
import com.chn.examen.repository.iClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements iClienteService{
    @Autowired
    private iClienteRepository clienteRepository;
    @Override
    public List<Cliente> findAll() {
        List<Cliente> lista;
        try{
            lista = clienteRepository.findAll();
        }catch(Exception e){
            throw e;
        }
        return lista;
    }

    @Override
    public int save(Cliente cliente) {
        int row;
        try{
            row = clienteRepository.save(cliente);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int update(Cliente cliente) {
        int row;
        try{
            row = clienteRepository.update(cliente);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int deleteBy(int id) {
        int row;
        try{
            row = clienteRepository.deleteBy(id);
        }catch(Exception e){
            throw e;
        }
        return row;
    }
}
