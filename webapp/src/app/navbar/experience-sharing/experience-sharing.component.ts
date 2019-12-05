import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { UserServiceService } from 'src/app/services/user-service.service';
import { Router } from '@angular/router';
import { BloodBankService } from 'src/app/services/blood-bank.service';
import { IExpSharing } from './iexp-sharing';

@Component({
  selector: 'app-experience-sharing',
  templateUrl: './experience-sharing.component.html',
  styleUrls: ['./experience-sharing.component.css']
})
export class ExperienceSharingComponent implements OnInit {

  
  State:any;
  Area:any;
  Pincode:any;
  Hospital:any;
  posted:boolean = false;
  ExperienceSharingForm: FormGroup;
  constructor(private formBuilder:FormBuilder,private userService:UserServiceService,private router :Router,private bloodBankService : BloodBankService) { }

  ngOnInit() {
    this.ExperienceSharingForm = this.formBuilder.group({
      state:['',[Validators.required]],
      hospitalArea:['',[Validators.required]],
      hospitalName:['',[Validators.required]],
      feedBack:['',[Validators.required]]
      
      })
      this.bloodBankService.getState().subscribe(
        (data :any) =>
        {
          console.log("states"+data);
          this.State=data;
        }
      )
  }

  get hospitalName() {
    return this.ExperienceSharingForm.get('hospitalName');
  }
  
  get state() {
    return this.ExperienceSharingForm.get('state');
  }

  get hospitalArea() {
   return this.ExperienceSharingForm.get('hospitalArea');
  }

  get feedBack() {
    return this.ExperienceSharingForm.get('feedBack');
  }
 
  selectState($event) {
   /// console.log("clicking"+event)
    this.bloodBankService.getArea($event.target.value).subscribe(
        (data) => {
  
        //  console.log("Area"+data);
          this.Area = data;
        }
    )
  }
  
  selectArea($event) {
    this.bloodBankService.getPincode($event.target.value).subscribe(
        (data : any) => {
      //    console.log("Pincode"+data);
          this.Pincode = data;
          this.bloodBankService.getHospitalList(this.Pincode).subscribe(
            (data:any) => {
              this.Hospital=data;
            }
          )
        }
    )
  }

  

  onClick(feedback: IExpSharing) 
  {
    console.log("Entered feed");
    console.log(feedback);
    let feedDetails: IExpSharing = { feedBack: feedback["feedBack"], hospitalName: feedback["hospitalName"],hospitalArea:feedback["hospitalArea"]};
    this.bloodBankService.postFeedBack(feedDetails,this.userService.userName).subscribe(
      (data) => {
       
         
          this.posted=true;
          alert("Posted successfully");
         
        
            },
      (error) => {
        console.log(error);
      }
    )
  }
}
