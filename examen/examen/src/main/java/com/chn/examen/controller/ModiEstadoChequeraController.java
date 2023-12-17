package com.chn.examen.controller;

import com.chn.examen.model.ModiEstadoChequera;
import com.chn.examen.model.ServiceResponsive;
import com.chn.examen.service.iModiEstadoChequeraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/modiChequera")
@CrossOrigin("*")
public class ModiEstadoChequeraController {
    @Autowired
    private iModiEstadoChequeraService iModificacionChequeraService;

    @PostMapping("/save")
    public ResponseEntity<ServiceResponsive> save(@RequestBody ModiEstadoChequera cuenta){
        ServiceResponsive   serviceResponsive = new ServiceResponsive();
        int result = iModificacionChequeraService.save(cuenta);
        if(result == 1 ){
            serviceResponsive.setMessage("Estado  Agregado Exitosamente");
        }

        return new ResponseEntity<>(serviceResponsive, HttpStatus.OK);
    }
}
