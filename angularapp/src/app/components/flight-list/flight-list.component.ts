import { Component, OnInit } from '@angular/core';
import { Flight } from 'src/app/models/flight.model';

@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {

  flights:Flight[] = [];
  errorMessage:string = '';
  userRole:string = '';

  constructor() { }

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
