package com.chn.examen.service;

import com.chn.examen.model.Cheque;
import com.chn.examen.model.Chequera;
import com.chn.examen.repository.iChequeRepository;
import com.chn.examen.repository.iChequeraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChequeService implements iChequeService{
    @Autowired
    private iChequeRepository chequeRepository;
    @Override
    public List<Cheque> findAll(int idChequera) {
        List<Cheque> lista;
        try{
            lista = chequeRepository.findAll(idChequera);
        }catch(Exception e){
            throw e;
        }
        return lista;
    }

    @Override
    public int save(Cheque cheque) {
        int row;
        try{
            row = chequeRepository.save(cheque);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int update(Cheque cheque) {
        int row;
        try{
            row = chequeRepository.update(cheque);
        }catch(Exception e){
            throw e;
        }
        return row;
    }
}
