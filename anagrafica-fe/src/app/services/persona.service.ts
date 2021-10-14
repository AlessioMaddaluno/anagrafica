import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Persona } from '../models/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  constructor(private http: HttpClient) { }

  search(dto : any) {
    let url = environment.baseApiUrl+"/persona/search";
    return this.http.post<any>(url,dto)
  }

  deleteById(id:number){
    let url = environment.baseApiUrl+`/persona/${id}`;
    return this.http.delete<any>(url)
  }

  save(dto: Persona){
    let url = environment.baseApiUrl+'/persona/';
    return this.http.post<any>(url,dto);
  }

  getById(id:number){
    let url = environment.baseApiUrl+`/persona/${id}`;
    return this.http.get<any>(url)
  }

  update(id:number,dto:Persona){
    let url = environment.baseApiUrl+`/persona/${id}`;
    return this.http.put<any>(url,dto);
  }

}
