package com.chn.examen.repository;

import com.chn.examen.model.Chequera;

import java.util.List;

public interface iChequeraRepository {
    public List<Chequera> findAll(int id);
    public int save(Chequera chequera);
    public int update(Chequera chequera);
}
