package com.chn.examen.repository;

import com.chn.examen.model.Cuenta;

import java.util.List;

public interface iCuentaRepository {
    public List<Cuenta> findAll(int id);
    public int save(Cuenta cuenta);
    public int update(Cuenta cuenta);
    public int deleteBy(int id);
}
