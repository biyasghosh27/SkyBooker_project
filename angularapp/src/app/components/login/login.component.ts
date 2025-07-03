import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email = '';
  password = '';
  errorMessage = '';

  constructor(private authService:AuthService, private router:Router) { }

  ngOnInit(): void {
  }
  //TESTING
  // console.log("trying to log in with ", this.user);
  
  login():void{
    const credentials = {
      email:this.email,
      password:this.password
    };

    this.authService.login(credentials).subscribe({
      next:(response)=>{
        this.authService.storeAuthData(response.token,response.userId,response.userRole);
        this.router.navigate(['/home']);
      },
      error:()=>this.errorMessage = 'Invalid credentials'
    });
  }

}
