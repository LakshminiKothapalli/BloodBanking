import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './site/home/home.component';
import { LoginComponent } from './site/login/login.component';
import { RegistrationComponent } from './site/registration/registration.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AboutusComponent } from './navbar/aboutus/aboutus.component';
import { BloodavailabilityComponent } from './navbar/bloodavailability/bloodavailability.component';
import { BlooddonationComponent } from './navbar/blooddonation/blooddonation.component';
import { BloodtipsComponent } from './navbar/bloodtips/bloodtips.component';
import { ContactusComponent } from './navbar/contactus/contactus.component';
import { RequestbloodComponent } from './navbar/requestblood/requestblood.component';
import { AvailableStatusComponent } from './navbar/available-status/available-status.component';
import { UserPageComponent } from './site/user-page/user-page.component';
import { SlotBookingComponent } from './navbar/slot-booking/slot-booking.component';
import { ExperienceSharingComponent } from './navbar/experience-sharing/experience-sharing.component';
import { AdminPageComponent } from './site/admin-page/admin-page.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    AboutusComponent,
    BloodavailabilityComponent,
    BlooddonationComponent,
    BloodtipsComponent,
    ContactusComponent,
    RequestbloodComponent,
    AvailableStatusComponent,
    UserPageComponent,
    SlotBookingComponent,
    ExperienceSharingComponent,
    AdminPageComponent
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
