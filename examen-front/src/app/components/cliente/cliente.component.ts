import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ClienteModel } from 'src/app/model/clienteModelo';
import { ClienteService } from 'src/app/service/cliente.service';
import { DatoCompartidoService } from 'src/app/service/dato-compartido.service'; 


@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.sass']
})
export class ClienteComponent implements OnInit {

  listCliente: ClienteModel [] = [];
  formCliente: FormGroup = new FormGroup({});
  isUpdate: boolean = false;
  isCuenta: boolean = false;
  cliente: number = 0;

  
  constructor(private clienteService: ClienteService, private datoCompartidoService: DatoCompartidoService) { }
  

  ngOnInit(): void {
    this.list();
    this.formCliente =  new FormGroup({
      id_cliente: new FormControl(''),
      nombre: new FormControl(''),
      apellido: new FormControl(''),
      numero_identificacion: new FormControl(''),
      fecha_nacimiento: new FormControl(''),
      direccion: new FormControl(''),
      correo_electronico: new FormControl(''),
      telefono: new FormControl(''),
      estado: new FormControl(true),
    });
  }

  list(){
    this.clienteService.getCliente().subscribe(resp=>{
      if(resp){
        this.listCliente = resp;
      }
    });
  }

  save(){
    this.formCliente.controls['estado'].setValue(true);
    this.clienteService.saveCliente(this.formCliente.value).subscribe(resp=>{
      if(resp){
        this.list();
        this.formCliente.reset();
      }
    });
  }

  update(){
    this.formCliente.controls['estado'].setValue(true);
    this.clienteService.updateCliente(this.formCliente.value).subscribe(resp=>{
      if(resp){
        this.list();
        this.formCliente.reset();
      }
    });
  }

  delete(id: any){
    this.clienteService.deleteCliente(id).subscribe(resp=>{
      if(resp){
        this.list();
      }
    });
  }

  newCard(){
    this.isUpdate = false;
    this.formCliente.reset();
  }

  selectItem(item: any){
    this.isUpdate = true;
    this.formCliente.controls['id_cliente'].setValue(item.id_cliente);
    this.formCliente.controls['nombre'].setValue(item.nombre);
    this.formCliente.controls['apellido'].setValue(item.apellido);
    this.formCliente.controls['numero_identificacion'].setValue(item.numero_identificacion);
    this.formCliente.controls['fecha_nacimiento'].setValue(item.fecha_nacimiento);
    this.formCliente.controls['direccion'].setValue(item.direccion);
    this.formCliente.controls['correo_electronico'].setValue(item.correo_electronico);
    this.formCliente.controls['telefono'].setValue(item.telefono);
    
  }

  mostrarCuenta(id: any){
    this.isCuenta = true;
    this.datoCompartidoService.globalVariable = id;
    this.clienteService.mostrarCuenta(id).subscribe(resp=>{
      if(resp){
        this.list();
      }
    });
    this.datoCompartidoService.actualizarComponenteA();
    
  }

  actualizarComponenteA() {
    // Llama al método del servicio para emitir el evento de actualización
    this.datoCompartidoService.actualizarComponenteA();
  }

}
