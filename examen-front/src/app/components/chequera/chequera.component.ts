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
  formChequera: FormGroup = new FormGroup({});
  isUpdate: boolean = false;
  isCuenta: boolean = true;
  

  private subscription: Subscription;


  constructor(private chequeraService: ChequeraService, private datoCompartidoService: DatoCompartidoService) {
    this.subscription = this.datoCompartidoService.actualizarComponenteAObservable$.subscribe(() => {
      // Lógica para actualizar ComponenteA
      console.log('Componente Chequera actualizado');
      this.cuenta = this.datoCompartidoService.getCuenta();
      this.list(this.cuenta);
    });
   }

  ngOnInit(): void {
    this.cuenta = this.datoCompartidoService.getCuenta();
    this.list(this.cuenta);
    this.formChequera =  new FormGroup({
      id_chequera : new FormControl(''),
      cantidad_cheque: new FormControl(''),
      id_Estado: new FormControl(''),
    });
  }

  list(id: any){
    id = this.cuenta;
    this.chequeraService.getCuenta(id).subscribe(resp=>{
      if(resp){
        this.listCliente = resp;
      }
    });
  }

  save(){
    this.formChequera.controls['id_Estado'].setValue('1');
    this.chequeraService.saveChequera(this.formChequera.value).subscribe(resp=>{
      if(resp){
        this.list(this.cuenta );
        this.formChequera.reset();
      }
    });
  }

  update(){
    this.formChequera.controls['id_EstadoCuenta'].setValue('1');
    this.chequeraService.updateChequera(this.formChequera.value).subscribe(resp=>{
      if(resp){
        this.list(this.cuenta);
        this.formChequera.reset();
      }
    });
  }

  

  newCard(){
    this.isUpdate = false;
    this.formChequera.reset();
  }

  selectItem(item: any){
    this.isUpdate = true;
    this.formChequera.controls['id_Chequera'].setValue(item.id_chequera);
    this.formChequera.controls['cantidad_cheque'].setValue(item.cantidad_cheque);
    
  }
}
