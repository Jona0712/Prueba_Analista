package com.chn.examen.service;

import com.chn.examen.model.Chequera;

import java.util.List;

public interface iChequeraService {
    public List<Chequera> findAll(int cuenta);
    public int save(Chequera chequera);
    public int update(Chequera chequera);
}
