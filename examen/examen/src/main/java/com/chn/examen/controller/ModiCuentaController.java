package com.chn.examen.controller;

import com.chn.examen.model.Cuenta;
import com.chn.examen.model.ModificacionEstadoCuenta;
import com.chn.examen.model.ServiceResponsive;
import com.chn.examen.service.iModificacionCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/modiCuenta")
@CrossOrigin("*")
public class ModiCuentaController {
    @Autowired
    private iModificacionCuentaService iModificacionCuentaService;

    @PostMapping("/save")
    public ResponseEntity<ServiceResponsive> save(@RequestBody ModificacionEstadoCuenta cuenta){
        ServiceResponsive   serviceResponsive = new ServiceResponsive();
        int result = iModificacionCuentaService.save(cuenta);
        if(result == 1 ){
            serviceResponsive.setMessage("Estado  Agregado Exitosamente");
        }

        return new ResponseEntity<>(serviceResponsive, HttpStatus.OK);
    }
}
