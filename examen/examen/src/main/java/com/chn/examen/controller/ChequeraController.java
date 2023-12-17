package com.chn.examen.controller;

import com.chn.examen.model.Chequera;
import com.chn.examen.model.ServiceResponsive;
import com.chn.examen.service.iChequeraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/chequera")
@CrossOrigin("*")
public class ChequeraController {
    @Autowired
    private iChequeraService iChequeraService;


    @GetMapping("/list/{id}")
    public ResponseEntity<List<Chequera>> list(@PathVariable int id){
        var result = iChequeraService.findAll(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponsive> save(@RequestBody Chequera chequera){
        ServiceResponsive   serviceResponsive = new ServiceResponsive();
        int result = iChequeraService.save(chequera);
        if(result == 1 ){
            serviceResponsive.setMessage("Chequera Agregada Exitosamente");
        }

        return new ResponseEntity<>(serviceResponsive, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponsive> update(@RequestBody Chequera chequera){
        ServiceResponsive   serviceResponsive = new ServiceResponsive();
        int result = iChequeraService.update(chequera);
        if(result == 1 ){
            serviceResponsive.setMessage("Chequera Modificada Exitosamente");
        }

        return new ResponseEntity<>(serviceResponsive, HttpStatus.OK);
    }
}
