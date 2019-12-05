import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/services/user-service.service';
import { IUser } from './iuser';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  registerForm: FormGroup;
 
  Gender: any = ['Male','Female']
  Bloodgroup: any = ['A+','A-','B+','B-','AB+','AB-','O+','O-']
  States: any = ['TamilNadu','Telangana','Karnataka','Kerala']
  Areas: any = ['Chennai','Vellore','Gachibowli','Secunderabad','Banglore','Mysore','Kochin']
 

  constructor(private formBuilder:FormBuilder,private userService:UserServiceService,private router :Router) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      username : ['',[
        Validators.required,
        this.isUsernameTaken
      ]],
      firstname:['',[
        Validators.required
      ]],
      lastname:['',[
        Validators.required
      ]],
      password:['',[
        Validators.required
      ]],
      confirmPassword:['',[
        Validators.required,
        this.matchConfirmPassword.bind(this)
      ]],
      age:['',[
        Validators.required
      ]],
      gender:['',[
        Validators.required
      ]],
      weight:['',[
        Validators.required
      ]],
      contactNo:['',[
        Validators.required
      ]],
      email:['',[
        Validators.required
      ]],
      bloodgroup:['',[
        Validators.required
      ]],
      state:['',[
        Validators.required
      ]],
      area:['',[
        Validators.required
      ]],
      pincode:['',[
        Validators.required
      ]]
    })
  }
  get username() {
    return this.registerForm.get('username');
  }
  get firstname() {
    return this.registerForm.get('firstname');
  }
  get lastname() {
    return this.registerForm.get('lastname');
  }
  get password() {
    return this.registerForm.get('password');
  }
  get confirmPassword() {
    return this.registerForm.get('confirmPassword');
  }
  get age() {
    return this.registerForm.get('age');
  }
  get gender() {
    return this.registerForm.get('gender');
  }
  get weight() {
    return this.registerForm.get('weight');
  }
  get contactNo() {
    return this.registerForm.get('contactNo');
  }
  get email() {
    return this.registerForm.get('email');
  }
  get bloodgroup() {
    return this.registerForm.get('bloodgroup');
  }
  get area() {
    return this.registerForm.get('area');
  }
  get state() {
    return this.registerForm.get('state');
  }
  get pincode() {
    return this.registerForm.get('pincode');
  }
  
  matchConfirmPassword(formControl: FormControl): { [s: string]: boolean } {
    if (this.registerForm) {
      if (formControl.value && formControl.value.length > 0 && formControl.value !== this.registerForm.get('password').value) {
        return { 'nomatch': true };
      }
    }
    return null;
  }
  isUsernameTaken(formControl: FormControl): { [s: string]: boolean } {
      if (formControl.value === 'admin') {
          return { 'userNameTaken': true };
        } else {
          return null;
        }
      }


      OnClickRegister(user: any) {
        let userDetails: IUser = { firstname: user["firstname"], lastname: user["lastname"], password: user["password"], username: user["username"], age :user["age"], gender:user["gender"], contactNo:user["contactNo"], email :user["email"], weight :user["weight"], bloodgroup:user["bloodgroup"],state : user["state"],area : user["area"],pincode : user["pincode"]};
        this.userService.addUser(userDetails).subscribe(
          (data) => {
            if (data) {
              this.router.navigate(['login'])
            }
            else {
              alert('Already Exists');
              this.router.navigate(['register'])
            }
          },
          (error) => {
            console.log(error);
          }
        )
      }

}

