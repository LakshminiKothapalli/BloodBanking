import { Component } from '@angular/core';
import { BloodBankService } from './services/blood-bank.service';
import { Router } from '@angular/router';
import { AuthServiceService } from './services/auth-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  ngOnInit(): void {
    this.loggedIn();
    this.router.navigate(['home']);
  }
  title = 'webapp';
  isLoggedIn: boolean = false;
  constructor(private authService: AuthServiceService, public router: Router, private bloodBankService: BloodBankService) {}
  loggedIn(): boolean {
    if (!this.authService.loggedInUser.loggedOut) {
      this.isLoggedIn = true;
      return true
    }
    else {
      this.isLoggedIn = false;
      return false;
    }
  }
}
