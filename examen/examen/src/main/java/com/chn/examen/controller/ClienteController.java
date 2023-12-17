package com.chn.examen.controller;

import com.chn.examen.model.Cliente;
import com.chn.examen.model.ServiceResponsive;
import com.chn.examen.service.iClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cliente")
@CrossOrigin("*")
public class ClienteController {
    @Autowired
    private iClienteService iClienteService;
    @GetMapping("/list")
    public ResponseEntity<List<Cliente>> list(){
        var result = iClienteService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ServiceResponsive> save(@RequestBody Cliente cliente){
        ServiceResponsive   serviceResponsive = new ServiceResponsive();
        int result = iClienteService.save(cliente);
        if(result == 1 ){
            serviceResponsive.setMessage("Cliente Agregado Exitosamente");
        }

        return new ResponseEntity<>(serviceResponsive, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponsive> update(@RequestBody Cliente cliente){
        ServiceResponsive   serviceResponsive = new ServiceResponsive();
        int result = iClienteService.update(cliente);
        if(result == 1 ){
            serviceResponsive.setMessage("Cliente Modificado Exitosamente");
        }

        return new ResponseEntity<>(serviceResponsive, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponsive> delete(@PathVariable int id){
        ServiceResponsive   serviceResponsive = new ServiceResponsive();
        int result = iClienteService.deleteBy(id);
        if(result == 1 ){
            serviceResponsive.setMessage("Cliente Eliminado Exitosamente");
        }

        return new ResponseEntity<>(serviceResponsive, HttpStatus.OK);
    }
}
