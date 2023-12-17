package com.chn.examen.service;

import com.chn.examen.model.ModiEstadoChequera;
import com.chn.examen.repository.iModiEstadoChequeraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModiEstadoChequeraService implements iModiEstadoChequeraService{
    @Autowired
    private iModiEstadoChequeraRepository modificacionChequeraRepository;
    @Override
    public int save(ModiEstadoChequera modificacionChequera) {
        int row;
        try{
            row = modificacionChequeraRepository.save(modificacionChequera);
        }catch(Exception e){
            throw e;
        }
        return row;
    }
}
