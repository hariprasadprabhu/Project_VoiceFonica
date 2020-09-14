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
  constructor(private _service: RegistrationService,private _router:Router) { }

  ngOnInit(): void {
  }

  loginCust()
  {
    this._service.loginCustomerFromRemote(this.cust).subscribe(
      data=>{console.log("response recived");
      this._router.navigate(['/loginsuccess'])
    },
      error=>{console.log("exception occured")
      this.msg="Bad Credentials, Please enter valid number and password"}
    );
  }
}
