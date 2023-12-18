import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DatoCompartidoService {
  public globalVariable: number =0;
  
  setGlobalVariable(valor: number){
    this.globalVariable = valor;
  }

  getGlobalVariable(){
    return this.globalVariable;
  }

  public cuenta : number=0;

  setCuenta (valor:number){
    this.cuenta = valor;
  }

  getCuenta(){
    return this.cuenta;
  }
  private actualizarComponenteASubject = new Subject<void>();

  // Observable para que los componentes se suscriban y reciban actualizaciones
  actualizarComponenteAObservable$ = this.actualizarComponenteASubject.asObservable();

  // Método para emitir un evento de actualización
  actualizarComponenteA() {
    this.actualizarComponenteASubject.next();
  }
}
