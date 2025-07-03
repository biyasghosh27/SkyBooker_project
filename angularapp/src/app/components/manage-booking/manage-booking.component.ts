import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/models/booking.model';
import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-manage-booking',
  templateUrl: './manage-booking.component.html',
  styleUrls: ['./manage-booking.component.css']
})
export class ManageBookingComponent implements OnInit {

  bookings:any[] = [];
  errorMessage:string = '';

  constructor(private bookingService:BookingService) { }

  ngOnInit(): void {
    this.loadBookings();
  }

  loadBookings():void{
    this.bookingService.getAllBookings().subscribe({
      next:(data)=>this.bookings = data,
      error:() => this.errorMessage = 'Failed to load bookings.'
    });
  }

  updateBookingStatus(bookingId:number, status:string):void{
    this.bookingService.updateBookingStatus(bookingId,status).subscribe({
      next:()=>this.loadBookings(),
      error:()=>this.errorMessage = 'Failed to update booking status.'
    });
  }

}
