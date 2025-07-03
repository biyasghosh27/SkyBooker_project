import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Flight } from 'src/app/models/flight.model';
import { FlightService } from 'src/app/services/flight.service';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {

  flight:any = {};
  isEditing:boolean = false;
  successMessage = "";
  errorMessage = "";

  constructor(private flightService:FlightService,
    private actRoute:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    const id = this.actRoute.snapshot.paramMap.get('id');
    if(id){
      this.isEditing = true;
      this.loadFlight(+id);
    }
  }

  loadFlight(id:number){
    this.flightService.getFlightById(id).subscribe({
      next:(data) => this.flight = data,
      error:()=>this.errorMessage = 'Failed to load flight.'
    });
  }

  addOrUpdateFlight(){
    const serviceCall = this.isEditing ? this.flightService.updateFlight(this.flight.flightId, this.flight)
    : this.flightService.createFlight(this.flight);

    serviceCall.subscribe({
      next:() =>{
        this.successMessage = this.isEditing ? 'Flight updated!' : 'Flight added!';
      },
      error:()=>this.errorMessage = 'Operation failed.'
    });
  }

  closeModal(){
    this.router.navigate(['/flight-list']);
  }
}
