package com.chn.examen.model;

import lombok.Data;

@Data
public class Cheque {
    int Id_Cheque;
    int Id_Chequera;
    int Id_Estado;
    Double Monto;
    String Fecha_Cheque;
    int Cuenta_acreditar;

}
