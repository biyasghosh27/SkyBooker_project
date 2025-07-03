import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public baseUrl = 'http://localhost:8080/api';

  // private userRole = new BehaviorSubject<string | null>(localStorage.getItem('userRole'));
  // private userId = new BehaviorSubject<number | null>(Number(localStorage.getItem('userId')));
  // private token = new BehaviorSubject<string | null>(localStorage.getItem('token'));

  constructor(private http:HttpClient, private router:Router) { }

  //Register user
  register(user:any):Observable<any>{
    return this.http.post(`${this.baseUrl}/register`,user);
  }

  //login user
  login(credentials:any):Observable<any>{
    return this.http.post(`${this.baseUrl}/login`,credentials);
  }

  //store user details in localstorage  + token too
  storeAuthData(token:string,userId:number,userRole:string):void{
    localStorage.setItem('token',token);
    localStorage.setItem('userId',userId.toString());
    localStorage.setItem('userRole',userRole);
    localStorage.setItem('username',extractUsernameFromEmail());
  }

  //check login status
  isLoggedIn():boolean{
    return !!localStorage.getItem('token');
  }
  
  getUserRole():string | null{
    return this.userRole.value;
  }

  //logout
  logout():void{
    localStorage.clear();
    this.router.navigate(['/login']);
  }

  getToken():string | null{
    return this.token.value;
  }

  isAdmin():boolean{
    return this.userRole.value === 'Admin';
  }

  isTraveller():boolean{
    return this.userRole.value === 'Traveller';
  }

  getUserId():number | null{
    return this.userId.value;
  }

}
