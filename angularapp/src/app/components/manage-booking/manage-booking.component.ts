import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/models/booking.model';

@Component({
  selector: 'app-manage-booking',
  templateUrl: './manage-booking.component.html',
  styleUrls: ['./manage-booking.component.css']
})
export class ManageBookingComponent implements OnInit {

  bookings:Booking[] = [];
  errorMessage:string = '';

  constructor() { }

  ngOnInit(): void {
    this.loadBookings();
  }

  loadBookings(){
    
  }

  updateBookingStatus(bookingId:number, status:string){

  }

}
