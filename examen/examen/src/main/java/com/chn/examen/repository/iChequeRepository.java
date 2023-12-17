package com.chn.examen.repository;

import com.chn.examen.model.Cheque;

import java.util.List;

public interface iChequeRepository {
    public List<Cheque> findAll(int idChequera);
    public int save(Cheque cheque);
    public int update(Cheque cheque);

}
