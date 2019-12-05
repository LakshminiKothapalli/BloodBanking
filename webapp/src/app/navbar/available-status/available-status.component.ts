import { Component, OnInit, Input } from '@angular/core';
import { BloodBankService } from 'src/app/services/blood-bank.service';
import { IUser } from 'src/app/site/registration/iuser';

@Component({
  selector: 'app-available-status',
  templateUrl: './available-status.component.html',
  styleUrls: ['./available-status.component.css']
})
export class AvailableStatusComponent implements OnInit {
  userList:IUser[];
  
  constructor(private bloodBankService:BloodBankService) { }

  ngOnInit() {
   
  }

    redirect()
    {
      this.userList =this.bloodBankService.getavailableUser();
      console.log(this.bloodBankService.availableUsers);
    console.log(this.userList);
    }
}
