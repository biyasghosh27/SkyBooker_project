import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService:AuthService, private router:Router){

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot):boolean {
    const isLoggedIn = this.authService.isLoggedIn();
    if(!isLoggedIn){
      this.router.navigate(['/login']);
      return false;
    }
    const path = route.url[0]?.path;
    if(path === 'add-flight'|| path === 'manage-booking'|| path === 'flight-list'){
      if(!this.authService.isAdmin()){
        this.router.navigate(['/forbidden']);
        return false;
      }
    }
    if(path === 'my-history'|| path === 'book-form' || path ==='flight-list'){
      if(!this.authService.isTraveller()){
        this.router.navigate(['/forbidden']);
        return false;
      }
    }
    return true;
  }
  
}
