import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user:any = {
    email:'',
    password:'',
    username:'',
    mobileNumber:'',
    userRole:'Traveller'
  }
  constructor() { }

  ngOnInit(): void {
  }

}
