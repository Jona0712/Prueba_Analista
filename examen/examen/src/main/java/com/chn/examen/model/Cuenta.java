package com.chn.examen.model;

import lombok.Data;

@Data
public class Cuenta {
    int id_Cuenta;
    int id_Cliente;
    String Tipo_Cuenta;
    Double Monto;
    int id_EstadoCuenta;


}
