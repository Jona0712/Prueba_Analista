import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClienteModel } from '../model/clienteModelo';
import { map } from 'rxjs/operators';
import { environment } from '../../enviroment/enviroment';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  URL_API: string = environment.apiUrl;
  constructor(private httpClient : HttpClient) { 

  }

  getCliente(): Observable<ClienteModel[]>{
    return this.httpClient.get<ClienteModel[]>(this.URL_API + "list").pipe(map(res => res));
  }
  saveCliente(request: any): Observable<any> {
    return this.httpClient.post<any>(this.URL_API + 'save', request).pipe(map(resp => resp));
  }

  updateCliente(request: any): Observable<any> {
    return this.httpClient.post<any>(this.URL_API + 'update', request).pipe(map(resp => resp));
  }

  deleteCliente(id: number): Observable<any> {
    return this.httpClient.get<any>(this.URL_API + 'delete/' + id).pipe(map(resp => resp));
  }

  mostrarCuenta(id: number): Observable<any> {
    return this.httpClient.get<any>(environment.apiCuenta + 'list/' + id).pipe(map(resp => resp));
  }
}
