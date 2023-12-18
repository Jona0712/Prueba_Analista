import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { CuentaModel } from '../model/cuentaModelo';
import { map } from 'rxjs/operators';
import { environment } from '../../enviroment/enviroment';
@Injectable({
  providedIn: 'root'
})
export class CuentaService {
  URL_API: string = environment.apiCuenta;
  constructor(private httpClient : HttpClient) { }

  getCuenta(id: number): Observable<CuentaModel[]>{
    return this.httpClient.get<CuentaModel[]>(this.URL_API + "list/" + id).pipe(map(res => res));
  }
  saveCuenta(request: any): Observable<any> {
    return this.httpClient.post<any>(this.URL_API + 'save', request).pipe(map(resp => resp));
  }

  updateCuenta(request: any): Observable<any> {
    return this.httpClient.post<any>(this.URL_API + 'update', request).pipe(map(resp => resp));
  }

  mostrarChequera(id: number): Observable<any> {
    return this.httpClient.get<any>(environment.apiChequera + 'list/' + id).pipe(map(resp => resp));
  }

}
