import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin';
import {LoginService} from '../login.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  admin=new Admin();
  constructor(private service:LoginService) { }

  ngOnInit(): void {
  }

  loginAdmin()
  {
    this.service.checkAdmin(this.admin).subscribe(
      (data) => console.log(data),
      (error) => console.log(error)
    );
  }
}
