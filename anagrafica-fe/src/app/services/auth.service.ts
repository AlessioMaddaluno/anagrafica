import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  jwtHelper:JwtHelperService = new JwtHelperService();

  private JWT_TOKEN_LOCAL_STORAGE = "JWT_TOKEN"
  private AUTHORIZATION_HEADER = 'Authorization'

  constructor(private http: HttpClient,private router:Router) {}

  signIn(dto : any){
    let url = environment.baseApiUrl+'/auth/accedi'
    return this.http.post(url,dto,{observe: 'response'})
    .pipe(map(res => {
      const JWT_TOKEN = res.headers.get(this.AUTHORIZATION_HEADER)?.replace('Bearer ','').trim();
      localStorage.setItem(this.JWT_TOKEN_LOCAL_STORAGE,JWT_TOKEN!)
      return res;
    }));
  }

  register(dto : any){
    let url = environment.baseApiUrl+'/auth/registrati'
    return this.http.post(url,dto,{observe: 'response'})
    .pipe(map(res => {
      const JWT_TOKEN = res.headers.get(this.AUTHORIZATION_HEADER)?.replace('Bearer ','').trim();
      localStorage.setItem(this.JWT_TOKEN_LOCAL_STORAGE,JWT_TOKEN!)
      return res;
    }));
  }

  getMe(){
    let url = environment.baseApiUrl+'/auth/me'
    return this.http.get(url)
  }

  logout(){
    localStorage.removeItem(this.JWT_TOKEN_LOCAL_STORAGE);
    this.router.navigate(['']);
  }

  isAuthenticated(){
    const token = localStorage.getItem(this.JWT_TOKEN_LOCAL_STORAGE);
    return token && !this.jwtHelper.isTokenExpired(token);
  }

}
