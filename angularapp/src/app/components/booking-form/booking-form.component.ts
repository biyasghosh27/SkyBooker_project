import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrls: ['./booking-form.component.css']
})
export class BookingFormComponent implements OnInit {

  flightId!:number;
  userEmail = localStorage.getItem('userEmail');
  booking:any = {
    numberOfPassengers:1,
    status:'Pending',
    bookingDate:new Date()
  };
  successMessage = '';
  errorMessage = '';
  showPlaneAnimation:boolean = false;

  constructor(private bookingService:BookingService,
    private authService:AuthService,
    private actRoute:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    const id = this.actRoute.snapshot.paramMap.get('id');
    if(id) this.flightId = +id;
  }

  submitBooking():void{
    const userId = this.authService.getUserId();
    if(!userId){
      this.errorMessage = 'User not logged in';
      return;
    }
    const bookingPayload = {
      ...this.booking,
      flight:{flightId:this.flightId},
      user:{userId:userId}
    };

    this.bookingService.createBooking(bookingPayload).subscribe({
      next:(response)=>{
        this.successMessage = `Booking successful for ${this.userEmail}`;
        this.showPlaneAnimation = true;
        
        //play sound
        const audio = new Audio('http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/music/start.ogg');
        audio.load();
        audio.play();

        //hide animation after 3 seconds
        setTimeout(()=>{
          this.showPlaneAnimation = false;
        },6500);
      },
      error:(err)=>{
        this.errorMessage = err.errorMessage || 'Booking failed. Please try again.';
      }
    });
  }

}

