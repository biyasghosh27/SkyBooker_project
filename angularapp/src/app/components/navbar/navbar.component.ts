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
    
  }

}
