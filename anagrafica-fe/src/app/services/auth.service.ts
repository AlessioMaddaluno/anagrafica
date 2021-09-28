import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  jwtHelper:JwtHelperService = new JwtHelperService();

  constructor(private http: HttpClient,private router:Router) {}

  signIn(dto : any){
    let url = 'http://localhost:8080/auth/accedi'
    return this.http.post(url,dto,{observe: 'response'})
    .pipe(map(res => {
      const JWT_TOKEN = res.headers.get('Authorization')?.replace('Bearer ','').trim();
      localStorage.setItem('JWT_TOKEN',JWT_TOKEN!)
      return res;
    }));
  }

  register(dto : any){
    let url = 'http://localhost:8080/auth/registrati'
    return this.http.post(url,dto,{observe: 'response'})
    .pipe(map(res => {
      const JWT_TOKEN = res.headers.get('Authorization')?.replace('Bearer ','').trim();
      localStorage.setItem('JWT_TOKEN',JWT_TOKEN!)
      return res;
    }));
  }

  getMe(){
    let url = 'http://localhost:8080/auth/me'
    return this.http.get(url)
  }

  logout(){
    localStorage.removeItem('JWT_TOKEN');
    this.router.navigate(['']);
  }

  isAuthenticated(){
    const token = localStorage.getItem('JWT_TOKEN');
    return token && !this.jwtHelper.isTokenExpired(token);
  }

}
