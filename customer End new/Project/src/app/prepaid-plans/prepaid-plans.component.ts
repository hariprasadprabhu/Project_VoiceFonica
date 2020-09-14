import { Component, OnInit } from '@angular/core';
import {Plans} from '../plans'
import {RegistrationService} from '../registration.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-prepaid-plans',
  templateUrl: './prepaid-plans.component.html',
  styleUrls: ['./prepaid-plans.component.css']
})
export class PrepaidPlansComponent implements OnInit {
  
  plans: Observable<Plans[]>;
  constructor(private _service: RegistrationService,private _router:Router) { }

  ngOnInit(): void {  
    this.reloadData();
  }
  reloadData() {
    this.plans = this._service.plansPrepaidCustomerFromRemote();
   }

  deleteEmployee(id)
  {

  }
}
