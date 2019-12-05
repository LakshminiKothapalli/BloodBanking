import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserServiceService } from 'src/app/services/user-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { BloodBankService } from 'src/app/services/blood-bank.service';
import { IHospital } from '../blooddonation/ihospital';

@Component({
  selector: 'app-slot-booking',
  templateUrl: './slot-booking.component.html',
  styleUrls: ['./slot-booking.component.css']
})
export class SlotBookingComponent implements OnInit {
  SlotForm: FormGroup;
  pincode:number;
 
 Area:any;
 Pincode:any;
  hospitals:IHospital[];
  noOfDonors:number;
  slotBooked:boolean;
  slotBlocked:boolean ;
  
  Timing:any=["09:00:00","11:00:00","01:00:00","03:00:00"];
  constructor(private formBuilder:FormBuilder,private userService:UserServiceService,private router :Router,private bloodBankService : BloodBankService,private route:ActivatedRoute) { }

  ngOnInit() {
   
    const pin = this.route.snapshot.paramMap.get('pincode');
    this.pincode = parseInt(pin);
    console.log("pincode"+this.pincode);
    this.bloodBankService.getHospitalList(this.pincode).subscribe(
      (data) => {
        this.hospitals = data;
        console.log("hospitals"+this.hospitals);
      }
    );
    this.SlotForm = this.formBuilder.group({
      username:['',[Validators.required]],
      state:['',[Validators.required]],
      area:['',[Validators.required]],
      pincode:['',[Validators.required]],
      time:['',[Validators.required]],
      hospitalname:['',[Validators.required]],
      date:['',[Validators.required]]
      
      })

      
  }

  get hospitalname() {
    return this.SlotForm.get('hospitalname');
  }
    get date() {
      return this.SlotForm.get('date');
    }
  
  get time() {
    return this.SlotForm.get('time');
  }




confirmSlot(value:any) {
  console.log("got valueeeeee"+value);
  this.bloodBankService.getNoOfDonors(value.hospitalname,value.date,value.time).subscribe(
    (data) => {
      console.log("time"+value.time);
      console.log("date"+value.date);
      console.log("no"+data);
      this.noOfDonors=data;
      if(this.noOfDonors < 3) {
          this.bloodBankService.postSlot(value,value.hospitalname).subscribe(
          (data) => {
            this.slotBooked=true;
            this.slotBlocked=false;
            alert("Slot Booked successfully..Have A nice day");
          }
        );
        
        }
        else {
          this.slotBlocked=true;
          this.slotBooked=false;
          alert("Selected slot is not available..Book another slot");
          
        }
    }
  );
  
}


}
