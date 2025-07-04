import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  showDropdown = false;
  showLogoutPopup = false;
  isLoggedIn = false;
  userRole = '';
  userName = '';

  constructor(private router:Router, private authService:AuthService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.authService.isLoggedIn();
    this.userRole = localStorage.getItem('userRole')||'';
    this.userName = localStorage.getItem('username')||'';
  }

  toggleDropdown():void{
    this.showDropdown = !this.showDropdown;
  }

  confirmLogout(){
    this.showLogoutPopup = true;
  }

  cancelLogout(){
    this.showLogoutPopup = false;
  }

  logout(){
    this.authService.logout();
    this.isLoggedIn = false;
    this.userRole = '';
    this.userName = '';
    this.showLogoutPopup = false;
    setTimeout(()=>{
      this.router.navigate(['/login']);
    },100);   
  }

}
