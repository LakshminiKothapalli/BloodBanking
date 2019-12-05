import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './site/home/home.component';
import { LoginComponent } from './site/login/login.component';
import { RegistrationComponent } from './site/registration/registration.component';
import { AppComponent } from './app.component';
import { AboutusComponent } from './navbar/aboutus/aboutus.component';
import { BloodavailabilityComponent } from './navbar/bloodavailability/bloodavailability.component';
import { BlooddonationComponent } from './navbar/blooddonation/blooddonation.component';
import { BloodtipsComponent } from './navbar/bloodtips/bloodtips.component';
import { ContactusComponent } from './navbar/contactus/contactus.component';
import { RequestbloodComponent } from './navbar/requestblood/requestblood.component';
import { AvailableStatusComponent } from '././navbar/available-status/available-status.component';
import { UserPageComponent } from './site/user-page/user-page.component';
import { SlotBookingComponent } from './navbar/slot-booking/slot-booking.component';
import { ExperienceSharingComponent } from './navbar/experience-sharing/experience-sharing.component';
import { AdminPageComponent } from './site/admin-page/admin-page.component';

const routes: Routes = [
  { path:'home', component : HomeComponent},
  {path:'login', component : LoginComponent},
  {path:'register', component : RegistrationComponent},
  {path:'aboutus', component : AboutusComponent},
  {path:'availability', component : BloodavailabilityComponent},
  {path:'blooddonation', component : BlooddonationComponent},
  {path:'bloodtips', component : BloodtipsComponent},
  {path:'contactus', component : ContactusComponent},
  {path:'requestblood', component : RequestbloodComponent},
  {path:'availablestatus', component : AvailableStatusComponent},
  {path:'userpage', component : UserPageComponent},
  {path:'bookslot/:pincode', component : SlotBookingComponent},
  {path:'feedBack', component : ExperienceSharingComponent},
  {path:'adminpage', component : AdminPageComponent},

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
