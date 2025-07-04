import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AddFlightComponent } from './components/add-flight/add-flight.component';
import { FlightListComponent } from './components/flight-list/flight-list.component';
import { ManageBookingComponent } from './components/manage-booking/manage-booking.component';
import { MyHistoryComponent } from './components/my-history/my-history.component';
import { BookingFormComponent } from './components/booking-form/booking-form.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ErrorComponent } from './components/error/error.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  {path:"",redirectTo:"/home",pathMatch:'full'},
  {path:"home",component:HomeComponent},
  {path:"login",component:LoginComponent},
  {path:"register",component:RegisterComponent},

  {path:"add-flight/:id",component:AddFlightComponent,canActivate:[AuthGuard]},
  {path:"add-flight",component:AddFlightComponent,canActivate:[AuthGuard]},
  {path:"flight-list",component:FlightListComponent,canActivate:[AuthGuard]},
  {path:"manage-booking",component:ManageBookingComponent,canActivate:[AuthGuard]},
  {path:"book-form",component:BookingFormComponent,canActivate:[AuthGuard]},
  {path:"book-form/:id",component:BookingFormComponent,canActivate:[AuthGuard]},
  {path:"my-history",component:MyHistoryComponent,canActivate:[AuthGuard]},
  
  {path:"**",component:ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
