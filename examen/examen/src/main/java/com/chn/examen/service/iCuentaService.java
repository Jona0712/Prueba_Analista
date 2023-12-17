package com.chn.examen.service;

import com.chn.examen.model.Cliente;
import com.chn.examen.model.Cuenta;

import java.util.List;

public interface iCuentaService {

    public List<Cuenta> findAll(int cuenta);
    public int save(Cuenta cuenta);
    public int update(Cuenta cuenta);
    public int deleteBy(int id);
}
