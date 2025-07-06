import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public baseUrl = 'https://8080-afbbeccaabcfe328808123edccecfbdeone.project.examly.io/api';

  // private userRole = new BehaviorSubject<string | null>(localStorage.getItem('userRole'));
  // private userId = new BehaviorSubject<number | null>(Number(localStorage.getItem('userId')));
  // private token = new BehaviorSubject<string | null>(localStorage.getItem('token'));

  //THIS USE OF ROUTER HERE FAILING TEST CASES
  constructor(private http:HttpClient,private router:Router) { }

  //Register user
  register(user:any):Observable<any>{
    return this.http.post(`${this.baseUrl}/register`,user);
  }

  //login user
  login(credentials:any):Observable<any>{
    return this.http.post(`${this.baseUrl}/login`,credentials);
  }

  //store user details in localstorage  + token too
  storeAuthData(token:string,userId:number,userRole:string,username:string,email:string):void{
    localStorage.setItem('token',token);
    localStorage.setItem('userId',userId.toString());
    localStorage.setItem('userRole',userRole);
    localStorage.setItem('username',username);
    localStorage.setItem('userEmail',email);
  }

  //check login status
  isLoggedIn():boolean{
    return !!localStorage.getItem('token');
  }

  isAdmin():boolean{
    return localStorage.getItem('userRole')==='Admin';
  }

  isTraveller():boolean{
    return localStorage.getItem('userRole')==='Traveller';
  }
  
  getUserRole():string{
    return localStorage.getItem('userRole')||'';
  }

  getUserId():number{
    return Number(localStorage.getItem('userId')||'0');
  }

  getToken():string{
    return localStorage.getItem('token')||'';
  }

  //logout
  logout():void{
    localStorage.clear();
    this.router.navigate(['/login']); //THIS ROUTING WAS FAILING TEST CASES
  }
  
}
