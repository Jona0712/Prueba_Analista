package com.chn.examen.service;

import com.chn.examen.model.Cheque;

import java.util.List;

public interface iChequeService {
    public List<Cheque> findAll(int idChequera);
    public int save(Cheque cheque);
    public int update(Cheque cheque);
}
