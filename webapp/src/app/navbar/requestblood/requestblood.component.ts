import { Component, OnInit } from '@angular/core';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { Router } from '@angular/router';
import { BloodBankService } from 'src/app/services/blood-bank.service';
import { IUser } from 'src/app/site/registration/iuser';
import { UserServiceService } from 'src/app/services/user-service.service';
import { IBloodRequest } from './iblood-request';

@Component({
  selector: 'app-requestblood',
  templateUrl: './requestblood.component.html',
  styleUrls: ['./requestblood.component.css']
})
export class RequestbloodComponent implements OnInit {

  Requestbloodform: FormGroup;
  Bloodgroup: any = ['A+','A-','B+','B-','AB+','AB-','O+','O-']
userList:IUser;
Area:any;
 Pincode:any;
 State:any;
 postRequest:boolean=false;
  
  constructor(private formBuilder:FormBuilder,private userService:UserServiceService,private router :Router,private bloodBankService : BloodBankService) { }

  ngOnInit() {
    this.Requestbloodform = this.formBuilder.group({
    name:['',[Validators.required]],
    contactNo:['',[Validators.required]],
    state:['',[Validators.required]],
    area:['',[Validators.required]],
    pincode:['',[Validators.required]],
    bloodGroup:['',[Validators.required]]
    
    })
    this.bloodBankService.getState().subscribe(
      (data :any) =>
      {
        console.log("hdgv****states---"+data);
        this.State=data;
      }
    )
  }
  get username() {
    return this.Requestbloodform.get('name');
  }
    get contactNo() {
      return this.Requestbloodform.get('contactNo');
    }
  
  get state() {
    return this.Requestbloodform.get('state');
  }

get area() {
  return this.Requestbloodform.get('area');
}
get pincode() {
  return this.Requestbloodform.get('pincode');
}
get bloodgroup() {
  return this.Requestbloodform.get('bloodGroup');
}

selectState($event) {
  console.log("****clicking*****"+event)
  this.bloodBankService.getArea($event.target.value).subscribe(
      (data) => {

        console.log("***Area***"+data);
        this.Area = data;
      }
  )
}

selectArea($event) {
  this.bloodBankService.getPincode($event.target.value).subscribe(
      (data : any) => {
        console.log("***Pincode***"+data);
        this.Pincode = data;
      }
  )
}
onRequestBlood(request:IBloodRequest) {
//console.log("request**"+request);
  this.bloodBankService.postRequirement(request,this.userService.userName).subscribe(
    data => {
  
      this.postRequest=true;
     });
   
}
}


