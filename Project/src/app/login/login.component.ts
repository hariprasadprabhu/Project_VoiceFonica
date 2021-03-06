import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer'
import {RegistrationService} from '../registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  cust = new Customer();
  msg=""
  constructor(private _service: RegistrationService,private _router:Router) {
    if(localStorage.getItem('key')!=null)
    {
     _router.navigate['loginsuccessful']   
    }
    else
    {
    }
   }

  ngOnInit(): void {
  }

  loginCust()
  {
    this._service.loginCustomerFromRemote(this.cust).subscribe(
      data=>{console.log("response recived");
      let value = this.cust.phoneNum;
      localStorage.setItem('key', (this.cust.phoneNum).toString());
      this._router.navigate(['/loginsuccess'])
    },
      error=>{console.log("exception occured")
      this.msg="Bad Credentials, Please enter valid number and password"}
    );
  }
}
