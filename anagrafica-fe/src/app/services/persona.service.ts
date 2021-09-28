import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Persona } from '../models/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  constructor(private http: HttpClient) { }

  search(dto : any) {
    return this.http.post<any>("http://localhost:8080/persona/search",dto)
  }

  deleteById(id:number){
    return this.http.delete<any>(`http://localhost:8080/persona/${id}`)
  }

  save(dto: Persona){
    return this.http.post<any>('http://localhost:8080/persona/',dto);
  }

  getById(id:number){
    return this.http.get<any>(`http://localhost:8080/persona/${id}`)
  }

  update(id:number,dto:Persona){
    return this.http.put<any>(`http://localhost:8080/persona/${id}`,dto);
  }

}
