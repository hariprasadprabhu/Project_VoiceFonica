import { Component, OnInit } from '@angular/core';
import {FormGroup, FormsModule, NgForm} from '@angular/forms';
import {RegistrationService} from '../registration.service';
import { Admin } from '../admin';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  password1:String;
  password2:String;
  regForm:FormGroup;
  admin=new Admin();
  flag=false;  
  constructor(private service:RegistrationService)
  {

  }
  ngOnInit(): void {
  }
  OnInput(event: any) {
    this.password1 = event.target.value;
    }
  OnInput1(event: any) 
  {
      this.password2 = event.target.value;
   }
   iscorrect():boolean
   {
     if(this.password1 === this.password2)
     {
        return false;
     }
     else
     {
       return true;
     }
   }
  registerAdmin()
  {
    this.service.storeDetails(this.admin).subscribe(
      data => console.log("perfect"),
      error => console.log("error occured")
    );
  }
}
