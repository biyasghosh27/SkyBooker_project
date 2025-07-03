import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  public baseUrl:string = 'http://localhost:8080/api';

  constructor(private http:HttpClient) { }

  getAllFlights():Observable<any>{
    return this.http.get(`${this.baseUrl}/flights`);
  }

  getFlightById(id:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/flights/${id}`);
  }

  createFlight(flight:any):Observable<any>{
    return this.http.post(`${this.baseUrl}/flights`,flight);
  }

  updateFlight(id:number, flight:any):Observable<any>{
    return this.http.put(`${this.baseUrl}/flights/${id}`,flight);
  }

  deleteFlight(id:number):Observable<any>{
    return this.http.delete(`${this.baseUrl}/flights/${id}`);
  }
}
