package com.chn.examen.repository;

import com.chn.examen.model.ModificacionEstadoCuenta;
import com.chn.examen.service.ModificacionCuentaService;

public interface iModiCuentaRepository {
    public int save(ModificacionEstadoCuenta modificacionEstadoCuenta);
}
