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

  const savedMode = localStorage.getItem('darkMode');
  this.isDarkMode = savedMode === 'true';
  this.applyDarkMode();
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

  isDarkMode = false;

  toggleDarkMode() {
  this.isDarkMode = !this.isDarkMode;
  const body = document.body;
  body.classList.toggle('dark-theme');
  const bg = document.querySelector('.home-background') as HTMLElement;
  if(bg){
    bg.style.backgroundImage =  body.classList.contains('dark-theme')
    ?
    "https://dribbble.com/shots/2112738-Long-journey"
    :
    "https://img.freepik.com/free-photo/comic-style-airplane-illustration_23-2151813588.jpg?semt=ais_hybrid&w=740";
  }
}

applyDarkMode() {
  if (this.isDarkMode) {
    document.body.classList.add('dark-mode');
  } else {
    document.body.classList.remove('dark-mode');
  }
}

}
