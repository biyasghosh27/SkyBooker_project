import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  public baseUrl = 'https://8080-afbbeccaabcfe328808123edccecfbdeone.project.examly.io/api';

  constructor(private http:HttpClient) { }

  createBooking(booking:any):Observable<any>{
    return this.http.post(`${this.baseUrl}/bookings`,booking);
  }

  getBookingById(id:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/bookings/${id}`);
  }

  getAllBookings():Observable<any>{
    return this.http.get(`${this.baseUrl}/bookings`);
  }

  getBookingsByUserId(userId:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/bookings/user/${userId}`);
  }

  updateBooking(id:number,booking:any):Observable<any>{
    return this.http.put(`${this.baseUrl}/bookings/${id}`,booking);
  }

  deleteBooking(id:number):Observable<any>{
    return this.http.delete(`${this.baseUrl}/bookings/${id}`);
  }

  updateBookingStatus(id:number,status:string):Observable<any>{  
    return this.http.put(`${this.baseUrl}/bookings/${id}`,{status});
  }
}
