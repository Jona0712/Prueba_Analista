package com.chn.examen.service;

import com.chn.examen.model.Cliente;
import com.chn.examen.model.Cuenta;
import com.chn.examen.repository.iCuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CuentaService implements iCuentaService{
    @Autowired
    private iCuentaRepository cuentaRepository;
    @Override
    public List<Cuenta> findAll(int cuenta) {
        List<Cuenta> lista;
        try{
            lista = cuentaRepository.findAll(cuenta);
        }catch(Exception e){
            throw e;
        }
        return lista;
    }

    @Override
    public int save(Cuenta cuenta) {
        int row;
        try{
            row = cuentaRepository.save(cuenta);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int update(Cuenta cuenta) {
        int row;
        try{
            row = cuentaRepository.update(cuenta);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int deleteBy(int id) {
        int row;
        try{
            row = cuentaRepository.deleteBy(id);
        }catch(Exception e){
            throw e;
        }
        return row;
    }


}
