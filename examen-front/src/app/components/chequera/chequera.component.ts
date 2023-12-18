import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ChequeraModel } from 'src/app/model/ChequeraModelo';
import { ChequeraService } from 'src/app/service/chequera.service';
import { DatoCompartidoService } from 'src/app/service/dato-compartido.service'; 
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-chequera',
  templateUrl: './chequera.component.html',
  styleUrls: ['./chequera.component.sass']
})
export class ChequeraComponent {
  public cuenta: number=0;

  
  listCliente: ChequeraModel [] = [];
  formCuenta: FormGroup = new FormGroup({});
  isUpdate: boolean = false;
  isCuenta: boolean = true;
  

  private subscription: Subscription;


  constructor(private chequeraService: ChequeraService, private datoCompartidoService: DatoCompartidoService) {
    this.subscription = this.datoCompartidoService.actualizarComponenteAObservable$.subscribe(() => {
      // Lógica para actualizar ComponenteA
      console.log('Componente A actualizado');
      this.cuenta = this.datoCompartidoService.getCuenta();
      this.list(this.cuenta);
    });
   }

  ngOnInit(): void {
    this.cuenta = this.datoCompartidoService.getCuenta();
    this.list(this.cuenta);
    this.formCuenta =  new FormGroup({
      id_chequera : new FormControl(''),
      cantidad_cheque: new FormControl(''),
      id_Estado: new FormControl(''),
    });
  }

  list(id: any){
    id = this.cliente;
    this.cuentaService.getCuenta(id).subscribe(resp=>{
      if(resp){
        this.listCliente = resp;
      }
    });
  }

  save(){
    this.formCuenta.controls['id_EstadoCuenta'].setValue('1');
    this.cuentaService.saveCuenta(this.formCuenta.value).subscribe(resp=>{
      if(resp){
        this.list(this.cliente);
        this.formCuenta.reset();
      }
    });
  }

  update(){
    this.formCuenta.controls['id_EstadoCuenta'].setValue('1');
    this.cuentaService.updateCuenta(this.formCuenta.value).subscribe(resp=>{
      if(resp){
        this.list(this.cliente);
        this.formCuenta.reset();
      }
    });
  }

  

  newCard(){
    this.isUpdate = false;
    this.formCuenta.reset();
  }

  selectItem(item: any){
    this.isUpdate = true;
    this.formCuenta.controls['id_Cuenta'].setValue(item.id_Cuenta);
    this.formCuenta.controls['tipo_Cuenta'].setValue(item.tipo_Cuenta);
    this.formCuenta.controls['monto'].setValue(item.monto);
    
  }
}
