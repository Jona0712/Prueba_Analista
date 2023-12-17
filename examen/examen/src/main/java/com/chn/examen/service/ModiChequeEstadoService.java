package com.chn.examen.service;

import com.chn.examen.model.ModiChequeEstado;
import com.chn.examen.repository.iModiChequeEstadoRepository;
import com.chn.examen.repository.iModiEstadoChequeraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModiChequeEstadoService implements iModiChequeEstadoService {
    @Autowired
    private iModiChequeEstadoRepository modificacionChequeRepository;
    @Override
    public int save(ModiChequeEstado modificacionCheque) {
        int row;
        try{
            row = modificacionChequeRepository.save(modificacionCheque);
        }catch(Exception e){
            throw e;
        }
        return row;
    }
}
