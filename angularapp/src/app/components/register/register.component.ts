import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user = {
    username:'',
    email:'',
    password:'',
    mobileNumber:'',
    userRole:''
  };
  
  confirmPassword:string ='';
  passwordMismatch:boolean=false;
  passwordPatternError:boolean= false;
  showModal:boolean=false;

  constructor(private authService:AuthService, private router:Router) { }

  ngOnInit(): void {
  }

  register():void{
    this.passwordMismatch = this.user.password !== this.confirmPassword;
    this.passwordPatternError = !/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^A-Za-z\d]).{8,}$/.test(this.user.password);
    if(this.passwordMismatch || this.passwordPatternError){
      return;
    }
    this.authService.register(this.user).subscribe({
      next:()=>{
        this.showModal = true;
      },
      error:()=>{
        alert('Registration failed')
      }
    });
  }

  goToLogin(){
    this.showModal = false;
    this.router.navigate['/login'];
  }

  closeModal(){
    this.showModal=false;
  }

}
