import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { CuentaModel } from 'src/app/model/cuentaModelo';
import { CuentaService } from 'src/app/service/cuenta.service';
import { DatoCompartidoService } from 'src/app/service/dato-compartido.service'; 
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-cuenta',
  templateUrl: './cuenta.component.html',
  styleUrls: ['./cuenta.component.sass']
})
export class CuentaComponent implements OnInit {
  
  listCliente: CuentaModel [] = [];
  formCuenta: FormGroup = new FormGroup({});
  isUpdate: boolean = false;
  isCuenta: boolean = true;
  cliente: number = 0;
  elementos = ['Ahorro', 'Monetaria'];
  seleccion: string ='';
  private subscription: Subscription;


  constructor(private cuentaService: CuentaService, private datoCompartidoService: DatoCompartidoService) {
    this.subscription = this.datoCompartidoService.actualizarComponenteAObservable$.subscribe(() => {
      // Lógica para actualizar ComponenteA
      console.log('Componente A actualizado');
      this.cliente = this.datoCompartidoService.getGlobalVariable();
      this.list(this.cliente);
    });
   }

  ngOnInit(): void {
    this.cliente = this.datoCompartidoService.getGlobalVariable();
    this.list(this.cliente);
    this.formCuenta =  new FormGroup({
      id_cuenta : new FormControl(''),
      id_cliente: new FormControl(''),
      tipo_Cuenta: new FormControl(''),
      monto: new FormControl(''),
      id_EstadoCuenta: new FormControl(''),
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

  mostrarChequera(id: any){
    this.isCuenta = true;
    this.datoCompartidoService.setCuenta(id);
    this.cuentaService.mostrarChequera(id).subscribe(resp=>{
      if(resp){
        this.list(id);
      }
    });
    this.datoCompartidoService.actualizarComponenteA();
    
  }
  
}
