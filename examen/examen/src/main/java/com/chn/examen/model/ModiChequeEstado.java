package com.chn.examen.model;

import lombok.Data;

@Data
public class ModiChequeEstado {
    int Id_registro;
    String Motivo_Actualizacion;
    String Fecha_Actualizacion;
    int Id_Cheque;
}
