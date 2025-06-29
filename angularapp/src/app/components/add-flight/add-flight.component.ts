import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {

  flight:object;
  isEditing:boolean;
  
  constructor() { }

  ngOnInit(): void {
  }


}
