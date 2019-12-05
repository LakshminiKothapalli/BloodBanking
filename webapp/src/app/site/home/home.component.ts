import { Component, OnInit } from '@angular/core';
import { BloodBankService } from 'src/app/services/blood-bank.service';
import { IBloodRequest } from 'src/app/navbar/requestblood/iblood-request';
import { IExpSharing } from 'src/app/navbar/experience-sharing/iexp-sharing';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  bloodRequests: IBloodRequest[];
  Experiences: IExpSharing[];
  constructor(private bloodBankService: BloodBankService) { }

  ngOnInit() {
    this.bloodBankService.getBloodRequests().subscribe(

      (data: IBloodRequest[]) => {
        console.log("request detailss*&**&" + data)
        this.bloodRequests = data;
      });

    this.bloodBankService.getExperience().subscribe(
      (data:IExpSharing[]) => {
        console.log("feeedback  detailss*&**&" + data)
        this.Experiences = data;
        console.log(this.Experiences);

      }
    )


  }


}
