import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ChequeraModel} from '../model/ChequeraModelo';
import { map } from 'rxjs/operators';
import { environment } from '../../enviroment/enviroment';

@Injectable({
  providedIn: 'root'
})
export class ChequeraService {

  URL_API: string = environment.apiChequera;
  constructor(private httpClient : HttpClient) { }

  getCuenta(id: number): Observable<ChequeraModel[]>{
    return this.httpClient.get<ChequeraModel[]>(this.URL_API + "list/" + id).pipe(map(res => res));
  }
  saveChequera(request: any): Observable<any> {
    return this.httpClient.post<any>(this.URL_API + 'save', request).pipe(map(resp => resp));
  }

  updateChequera(request: any): Observable<any> {
    return this.httpClient.post<any>(this.URL_API + 'update', request).pipe(map(resp => resp));
  }
}
