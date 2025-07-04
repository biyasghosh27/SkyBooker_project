import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from 'src/app/models/flight.model';
import { AuthService } from 'src/app/services/auth.service';
import { FlightService } from 'src/app/services/flight.service';

@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {

  //THIS
  flights:Flight[] = [];
  errorMessage:string = '';
  userRole:string = '';

  constructor(private flightService:FlightService,
    private authService:AuthService,
    private router:Router) { }

  ngOnInit(): void {
    this.userRole = this.authService.getUserRole()||'';
    this.loadFlights();
  }

  loadFlights(){
    this.flightService.getAllFlights().subscribe({
      next:(data)=>this.flights=data,
      error:()=>this.errorMessage = 'Failed to load flights.'
    });
  }

  //THIS
  updateFlight(id:number){
    this.router.navigate(['/add-flight',id]);
  }

  //THIS
  deleteFlight(id:number){
    this.flightService.deleteFlight(id).subscribe({
      next:()=>this.loadFlights(),
      error:()=>this.errorMessage = 'Failed to delete flight.'
    });
  }

  navigateToBooking(flightId:number){
    this.router.navigate(['/book-form',flightId]);
  }
}
