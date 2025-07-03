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

  flights:Flight[] = [];
  errorMessage:string = '';
  userRole:string = '';

  constructor(private flightService:FlightService,
    private authService:AuthService,
    private router:Router) { }

  ngOnInit(): void {
    this.loadFlights();
  }

  loadFlights(){
    return this.flights;
  }

  updateFlight(id:number){

  }

  deleteFlight(id:number){

  }

  navigateToBooking(flightId:number){
    
  }
}
