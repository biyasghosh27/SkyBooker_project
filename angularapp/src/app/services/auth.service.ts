import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public baseUrl = 'http://localhost:8080/api';

  private userRole = new BehaviorSubject<string | null>(localStorage.getItem('userRole'));
  private userId = new BehaviorSubject<number | null>(Number(localStorage.getItem('userId')));
  private token = new BehaviorSubject<string | null>(localStorage.getItem('token'));

  constructor(private http:HttpClient) { }

  register(user:any):Observable<any>{
    return this.http.post(`${this.baseUrl}/register`,user);
  }

  login(credentials:any):Observable<any>{
    return this.http.post(`${this.baseUrl}/login`,credentials);
  }

  storeAuthData(token:string,userId:number,userRole:string):void{
    localStorage.setItem('token',token);
    localStorage.setItem('userId',userId)
  }
}
