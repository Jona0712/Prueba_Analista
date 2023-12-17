package com.chn.examen.controller;

import com.chn.examen.model.Cheque;
import com.chn.examen.model.Chequera;
import com.chn.examen.model.ServiceResponsive;
import com.chn.examen.service.iChequeService;
import com.chn.examen.service.iChequeraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cheque")
@CrossOrigin("*")
public class ChequeController {
    @Autowired
    private iChequeService iChequeService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<Cheque>> list(@PathVariable int id){
        var result = iChequeService.findAll(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponsive> save(@RequestBody Cheque cheque){
        ServiceResponsive   serviceResponsive = new ServiceResponsive();
        int result = iChequeService.save(cheque);
        if(result == 1 ){
            serviceResponsive.setMessage("Cheque Agregada Exitosamente");
        }

        return new ResponseEntity<>(serviceResponsive, HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<ServiceResponsive> update(@RequestBody Cheque cheque){
        ServiceResponsive   serviceResponsive = new ServiceResponsive();
        int result = iChequeService.update(cheque);
        if(result == 1 ){
            serviceResponsive.setMessage("Cheque Modificada Exitosamente");
        }

        return new ResponseEntity<>(serviceResponsive, HttpStatus.OK);
    }
}
