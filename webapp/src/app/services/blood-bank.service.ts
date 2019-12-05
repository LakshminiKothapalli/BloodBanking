import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserServiceService } from './user-service.service';
import { Observable } from 'rxjs';
import { IUser } from '../site/registration/iuser';
import { AuthServiceService } from './auth-service.service';
import { environment } from 'src/environments/environment';
import { IBloodRequest } from '../navbar/requestblood/iblood-request';
import { IHospital } from '../navbar/blooddonation/ihospital';
import { Time } from '@angular/common';
import { ISlot } from '../navbar/slot-booking/islot';
import { IExpSharing } from '../navbar/experience-sharing/iexp-sharing';
import { IAddress } from '../navbar/iaddress';

@Injectable({
  providedIn: 'root'
})
export class BloodBankService {

  token:any;
  isAdmin: boolean = false;
  isBloodAvailable:boolean;
  isLoggedIn: boolean = false;
  availableUsers:IUser[];
  userName:string;
 
  constructor(private http: HttpClient) { 
    
  }

  public getavailableUser() {
   // console.log("getting"+this.availableUsers);
    console.log(this.availableUsers);
    return this.availableUsers;
  }
  public setavailableUser(availableUsers) {
// console.log("setting "+availableUsers);
  //  console.log(availableUsers);
     this.availableUsers=availableUsers;
  }

  getState(): Observable<any> {
  //  console.log("State")
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.token);
    return this.http.get<IAddress[]>(environment.baseUrl + "/bloodbank-service/address/state", { headers });

  }

  getArea(state): Observable<any> {
   // console.log("getArea")
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.token);
    return this.http.get<any>(environment.baseUrl+"/bloodbank-service/address/area/"+state, { headers })
  }
  
  getPincode(area): Observable<any> {
  //  console.log("getPincode")
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.token);
    return this.http.get<any>(environment.baseUrl+"/bloodbank-service/address/pincode/"+area, { headers })
  }
  
  public checkAvailability(bloodgroup :string,pincode:number): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.token);
    return this.http.get<IUser[]>(environment.baseUrl + "/bloodbank-service/request/"+bloodgroup+"/"+pincode, { headers });
  }

  public postRequirement(request:IBloodRequest,username:string): Observable<any> {
  //  console.log("posting"+request);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.token);
    console.log("token"+this.token)
    console.log(headers);
    return this.http.post(environment.baseUrl + "/bloodbank-service/request/"+username,request,{ headers });
  }

  public getBloodRequests(): Observable<any> {
   
    return this.http.get<IBloodRequest[]>(environment.baseUrl + "/bloodbank-service/request");
  }

  
  public getHospitalList(pincode:number): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.token);
    return this.http.get<IHospital[]>(environment.baseUrl + "/bloodbank-service/slot/hospital/"+pincode , { headers });
  }

  public getNoOfDonors(hospitalname:string,date:Date,time:Time): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.token);
    return this.http.get<IHospital[]>(environment.baseUrl + "/bloodbank-service/slot/"+hospitalname+"/"+date+"/"+time , { headers });
  }

  public postSlot(slot:ISlot,hospitalname:string): Observable<any> {
    console.log("posting"+slot);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.token);
    console.log("token"+this.token)
    console.log(headers);
    return this.http.post(environment.baseUrl + "/bloodbank-service/slot/"+hospitalname,slot,{ headers });
  }

  
  public postFeedBack(feedBack:IExpSharing,username:string): Observable<any> {
    console.log("posting"+feedBack);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.token);
    console.log("token"+this.token)
    console.log(headers);
    return this.http.post(environment.baseUrl + "/bloodbank-service/experience/"+username,feedBack, { headers });
  }

  public getExperience(): Observable<any> {
    return this.http.get<IExpSharing[]>(environment.baseUrl + "/bloodbank-service/experience");
  }

}
