package com.chn.examen.service;

import com.chn.examen.model.Chequera;
import com.chn.examen.model.Cuenta;
import com.chn.examen.repository.iChequeraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChequeraService implements iChequeraService{

    @Autowired
    private iChequeraRepository chequeraRepository;
    @Override
    public List<Chequera> findAll(int cuenta) {
        List<Chequera> lista;
        try{
            lista = chequeraRepository.findAll(cuenta);
        }catch(Exception e){
            throw e;
        }
        return lista;
    }

    @Override
    public int save(Chequera chequera) {
        int row;
        try{
            row = chequeraRepository.save(chequera);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int update(Chequera chequera) {
        int row;
        try{
            row = chequeraRepository.update(chequera);
        }catch(Exception e){
            throw e;
        }
        return row;
    }
}
