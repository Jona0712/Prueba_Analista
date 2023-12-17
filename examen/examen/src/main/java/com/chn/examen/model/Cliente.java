package com.chn.examen.model;

import lombok.Data;

@Data
public class Cliente {
    int id_cliente;
    String nombre;
    String apellido;
    String numero_identificacion;
    String fecha_nacimiento;
    String direccion;
    String correo_electronico;
    String telefono;
    boolean estado;


}
