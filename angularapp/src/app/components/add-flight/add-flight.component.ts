import { Component, OnInit } from '@angular/core';
import { Flight } from 'src/app/models/flight.model';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {

  flight:Flight;
  isEditing:boolean;
  successMessage = "";
  errorMessage = "";

  constructor() { }

  ngOnInit(): void {
    
  }

  loadFlight(id:string){

  }

  addOrUpdateFlight(){

  }

  closeModal(){
    
  }
}
