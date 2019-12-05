import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/services/user-service.service';
import { IUser } from 'src/app/site/registration/iuser';
import { BloodBankService } from 'src/app/services/blood-bank.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-bloodavailability',
  templateUrl: './bloodavailability.component.html',
  styleUrls: ['./bloodavailability.component.css']
})
export class BloodavailabilityComponent implements OnInit {

  Bloodavailableform: FormGroup;
  Bloodgroup: any = ['A+','A-','B+','B-','AB+','AB-','O+','O-']
  userList : any;
  Area:any;
  Pincode:number;
  State:any;
  
  constructor(private formBuilder:FormBuilder,private userService:UserServiceService,public router :Router,private bloodBankService : BloodBankService, private http:HttpClient) { }
status:boolean;
  ngOnInit() {
    this.Bloodavailableform = this.formBuilder.group({
      username:['',[Validators.required]],
      contactNo:['',[Validators.required]],
      state:['',[Validators.required]],
      area:['',[Validators.required]],
      pincode:['',[Validators.required]],
      bloodgroup:['',[Validators.required]]
      
      })

      this.bloodBankService.getState().subscribe(
        (data :any) =>
        {
        
          this.State=data;
        }
      )
  }
  get username() {
    return this.Bloodavailableform.get('username');
  }
    get contactNo() {
      return this.Bloodavailableform.get('contactNo');
    }
  
  get state() {
    return this.Bloodavailableform.get('state');
  }

get area() {
  return this.Bloodavailableform.get('area');
}
get pincode() {
  return this.Bloodavailableform.get('pincode');
}
get bloodgroup() {
  return this.Bloodavailableform.get('bloodgroup');
}



selectState($event) {
  console.log("clicking"+event)
  this.bloodBankService.getArea($event.target.value).subscribe(
      (data) => {

        console.log("Area"+data);
        this.Area = data;
      }
  )
}

selectArea($event) {
  this.bloodBankService.getPincode($event.target.value).subscribe(
      (data : any) => {
        console.log("Pincode"+data);
        this.Pincode = data;
      }
  )
}
isAvailable(availability:any) {
  console.log(availability);
 this.bloodBankService.checkAvailability(availability.bloodgroup, availability.pincode).subscribe(
  
  (data: IUser[]) => {
    if(data.length==0) {
      this.bloodBankService.isBloodAvailable = false;
    
    }
    else if(data.length!=0){
      this.bloodBankService.isBloodAvailable = true;
      this.userList = data;
      this.status=true;
     this.bloodBankService.setavailableUser(this.userList) ;
    }
  });

  this.router.navigate(['availablestatus']);

}
}
