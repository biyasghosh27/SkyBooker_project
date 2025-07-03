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
    localStorage.setItem('userId',userId.toString());
    localStorage.setItem('userRole',userRole);
    this.userRole.next(userRole);
    this.userId.next(userId);
    this.token.next(token);
  }

  logout():void{
    localStorage.clear();
    this.userRole.next(null);
    this.userId.next(null);
    this.token.next(null);
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

  getUserRole():string | null{
    return this.userRole.value;
  }
}
