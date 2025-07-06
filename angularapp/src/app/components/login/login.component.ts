import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = {
    email:'',
    password: ''
  }

  loginError:string ='';

  constructor(private authService:AuthService, private router:Router) { }

  ngOnInit(): void {
  }
  
  login():void{
   this.authService.login(this.credentials).subscribe({
    next:(res)=>{
      this.authService.storeAuthData(res.token, res.userId, res.userRole, res.username, res.email);
      this.router.navigate(['/home']).then(()=>
      window.location.reload());
      //needed when not working properly
    },
    error:()=>{
      this.loginError = 'Invalid email or password';
    }
   });
  }

}
