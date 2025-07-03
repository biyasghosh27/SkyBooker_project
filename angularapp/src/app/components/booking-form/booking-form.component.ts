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
  booking:any = {
    numberOfPassengers:1,
    status:'Pending',
    bookingDate:new Date()
  };
  successMessage = '';
  errorMessage = '';

  constructor(private bookingService:BookingService,
    private authService:AuthService,
    private actRoute:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    const id = this.router
  }

}
