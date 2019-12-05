import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserServiceService } from './user-service.service';
import { BloodBankService } from './blood-bank.service';
@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  loggedInUser = { loggedOut: true };
  validCredentials: boolean = true;
  accessToken: string;
  redirectUrl = '/';
  loggedIn: boolean = false;
  name: string;
  baseUrl = environment.baseUrl;
  private token: string;
  error: string = "Login Failed";
  id: number;

  authenticateSpring(user: string, password: string): Observable<any> {
    let credentials = btoa(user + ':' + password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + credentials)
    return this.httpClient.get(this.baseUrl + "/authentication-service/authenticate", { headers })
  }
  public setToken(token: string) {
      this.token = token;
  }
  public getToken() {
    return this.token;
  }
  public getId() {
    return this.id;
  }

  public setId(id: number) {
    this.id = id;
  }

  constructor(private userService: UserServiceService, public router: Router, private httpClient: HttpClient, private bloodBankService: BloodBankService) { }

  authenticateUser(user) {
    this.authenticateSpring(user.username, user.password).subscribe(
      (data) => {
        console.log("data"+data);
        console.log("username"+user.username);
        this.loggedInUser = user.username;
       
        this.validCredentials = true;
        this.loggedIn = true;
        this.bloodBankService.isLoggedIn = true;
        this.bloodBankService.token=data.token;
        console.log(this.bloodBankService.token);
        console.log("token"+data.token)
        this.setToken(data.token);
        this.bloodBankService.userName=data.username;
        this.userService.userName = data.username;
        this.userService.userRole = data.role;

        if (this.userService.userRole == 'ADMIN') {
          this.bloodBankService.isAdmin = true;
          this.router.navigate(['adminpage']);

        }
        else {
          this.bloodBankService.isAdmin = false;
          this.router.navigate(['userpage']);

        }
      
        
      },
      (error) => {
        this.validCredentials = false;
      }
    )
  }
  logout() {
    this.loggedInUser = { loggedOut: true };
    this.bloodBankService.isAdmin = false;
    this.loggedIn = false;
    this.bloodBankService.isLoggedIn = false;
       this.router.navigate(['home']);

  }
}
