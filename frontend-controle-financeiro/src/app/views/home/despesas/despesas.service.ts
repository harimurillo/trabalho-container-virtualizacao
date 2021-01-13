import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'
import { RequestCreate, ResponseCreate, ResponseDespesa, ResponseDespesas } from './user.model';


@Injectable({
  providedIn: 'root'
})

export class DespesasService {

  private url = "http://localhost:8080/despesas";

  constructor(private http: HttpClient) { }

  getDespesas(): Observable<ResponseDespesas[]>{
    return this.http.get<ResponseDespesas[]>(this.url)
  }

  createDespesas(request: RequestCreate): Observable<ResponseCreate>{
    return this.http.post<ResponseCreate>(this.url, request)
  }

  getDespesa(id: string): Observable<ResponseDespesas>{
    const _url =  `${this.url}/${id}`;
    return this.http.get<ResponseDespesas>(_url)
  }

  updateDespesas(id: string, request: RequestCreate): Observable<ResponseCreate>{
    const _url =  `${this.url}/${id}`;
    return this.http.put<ResponseCreate>(_url, request)
  }

  deleteDespesa(id: string): Observable<any>{
    const _url =  `${this.url}/${id}`;
    return this.http.delete<any>(_url)
  }
}
