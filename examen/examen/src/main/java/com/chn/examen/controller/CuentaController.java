package com.chn.examen.controller;

import com.chn.examen.model.Cliente;
import com.chn.examen.model.Cuenta;
import com.chn.examen.model.ServiceResponsive;
import com.chn.examen.service.iCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cuenta")
@CrossOrigin("*")
public class CuentaController {

    @Autowired
    private iCuentaService iCuentaService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<Cuenta>> list(@PathVariable int id){
        var result = iCuentaService.findAll(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponsive> save(@RequestBody Cuenta cuenta){
        ServiceResponsive   serviceResponsive = new ServiceResponsive();
        int result = iCuentaService.save(cuenta);
        if(result == 1 ){
            serviceResponsive.setMessage("Cuenta Agregada Exitosamente");
        }

        return new ResponseEntity<>(serviceResponsive, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponsive> update(@RequestBody Cuenta cuenta){
        ServiceResponsive   serviceResponsive = new ServiceResponsive();
        int result = iCuentaService.update(cuenta);
        if(result == 1 ){
            serviceResponsive.setMessage("Cuenta Modificada Exitosamente");
        }

        return new ResponseEntity<>(serviceResponsive, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponsive> delete(@PathVariable int id){
        ServiceResponsive   serviceResponsive = new ServiceResponsive();
        int result = iCuentaService.deleteBy(id);
        if(result == 1 ){
            serviceResponsive.setMessage("Cuenta Eliminada Exitosamente");
        }

        return new ResponseEntity<>(serviceResponsive, HttpStatus.OK);
    }

}
