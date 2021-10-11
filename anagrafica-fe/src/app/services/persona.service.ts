import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Persona } from '../models/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  constructor(private http: HttpClient) { }

  search(dto : any) {
    return this.http.post<any>("/api/persona/search",dto)
  }

  deleteById(id:number){
    return this.http.delete<any>(`/api/persona/${id}`)
  }

  save(dto: Persona){
    return this.http.post<any>('/api/persona/',dto);
  }

  getById(id:number){
    return this.http.get<any>(`/api/persona/${id}`)
  }

  update(id:number,dto:Persona){
    return this.http.put<any>(`/api/persona/${id}`,dto);
  }

}
