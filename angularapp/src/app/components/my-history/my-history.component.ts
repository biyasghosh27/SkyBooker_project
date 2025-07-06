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
  userEmail:string = String(localStorage.getItem('userEmail'))||'';
  showModal:boolean = false;
  modalMessage:string = '';
  
  constructor(private bookingService:BookingService,
    private authService:AuthService) { }

  ngOnInit(): void {
    this.userId = this.authService.getUserId();
    if(this.userId!==null)
    this.loadUserBookings();
  }

  loadUserBookings(){
    const userId = this.authService.getUserId();

    this.bookingService.getBookingsByUserId(userId).subscribe({
      next:(data)=>{
        this.bookings = data,
        this.checkForStatusChange();
      },
      error:()=>this.errorMessage = 'Failed to load your bookings.'
    });
  }

  checkForStatusChange():void{
    const approvedBooking = this.bookings.find(b => b.status === 'Approved');
    const rejectedBooking = this.bookings.find(b => b.status === 'Rejected');
    if(approvedBooking){
      this.modalMessage = `Booking Approved for ${this.userEmail}`;
      this.showModal = true;
    }else if(rejectedBooking){
      this.modalMessage = `Booking Rejected for ${this.userEmail}`;
      this.showModal = true;
    }
  }

}
