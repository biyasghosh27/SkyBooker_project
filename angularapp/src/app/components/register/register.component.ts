import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

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
  };
  errorMessage = '';
  successMessage = '';

  constructor(private authService:AuthService, private router:Router) { }

  ngOnInit(): void {
  }

  register():void{
    this.authService.register(this.user).subscribe({
      next:()=>{
        this.successMessage = 'Registered successfully!';
        setTimeout(()=>this.router.navigate(['/login']),1000);
      },
      error:()=>this.errorMessage = 'Registration failed'
    });
  }

}
