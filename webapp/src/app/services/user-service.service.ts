import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

import { IUser } from './../site/registration/iuser';


@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
 
  userRole: string;
  userName: string;

  constructor(private router: Router, private httpClient: HttpClient) { }
  addUser(user: IUser): Observable<any> {
    return this.httpClient.post<IUser>(environment.baseUrl + "/authentication-service/users", user);
  }

}
