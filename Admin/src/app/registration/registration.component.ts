import { Component, OnInit } from '@angular/core';
import { Route } from '@angular/compiler/src/core';
import { error } from '@angular/compiler/src/util';
import {FormGroup, NgForm} from '@angular/forms';
import { Router } from '@angular/router';

import {RegidtrationService} from '../regidtration.service';
import { User } from '../user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  password1:String;
  password2:String;
  regForm:FormGroup;
  user =new User();
  flag=false;
  msg='';

  constructor(private _service : RegidtrationService, private _router : Router) { }

  ngOnInit(): void {
  }

  OnInput(event: any)
  {
    this.password1=event.target.value;
  }

  OnInput1(event: any)
  {
    this.password2=event.target.value;
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

  registerUser()
  {
    this._service.registerUserFromRemote(this.user).subscribe(
      data => {console.log("response received");
      this.msg="Registration successful!!";
      this._router.navigate(['/login'])
    },
      error => {
        console.log("exception occured");
        this.msg=error.error;
      }
    )
    }
    gotoregistration()
    {
      this._router.navigate(['/registration'])
    }
}
