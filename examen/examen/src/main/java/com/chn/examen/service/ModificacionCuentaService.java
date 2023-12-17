package com.chn.examen.service;

import com.chn.examen.model.ModificacionEstadoCuenta;
import com.chn.examen.repository.iModiCuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModificacionCuentaService implements iModificacionCuentaService {
    @Autowired
    private iModiCuentaRepository modificacionCuentaRepository;
    @Override
    public int save(ModificacionEstadoCuenta modificacionCuenta) {
        int row;
        try{
            row = modificacionCuentaRepository.save(modificacionCuenta);
        }catch(Exception e){
            throw e;
        }
        return row;
    }
}
