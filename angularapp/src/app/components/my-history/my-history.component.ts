import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-my-history',
  templateUrl: './my-history.component.html',
  styleUrls: ['./my-history.component.css']
})
export class MyHistoryComponent implements OnInit {

  bookings:any[] = [];
  errorMessage:string = '';
  userId:number = Number(localStorage.getItem('userId'));
  userEmail:string = String(localStorage.getItem('userEmail'));
  
  constructor(private bookingService:BookingService,
    private authService:AuthService) { }

  ngOnInit(): void {
    this.userId = this.authService.getUserId();
    if(this.userId!==null)
    this.loadUserBookings();
  }

  loadUserBookings(){
    this.bookingService.getBookingsByUserId(this.userId!).subscribe({
      next:(data)=>this.bookings = data,
      error:()=>this.errorMessage = 'Failed to load your bookings.'
    });
  }

}
