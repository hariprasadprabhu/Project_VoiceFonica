import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Details } from '../details';
import { Plans } from '../plans';
import { RegistrationService } from '../registration.service';
import {Posthistory} from '../posthistory';
@Component({
  selector: 'app-postpaidhome',
  templateUrl: './postpaidhome.component.html',
  styleUrls: ['./postpaidhome.component.css']
})
export class PostpaidhomeComponent implements OnInit {

  plans: Observable<Plans[]>;
  act;
  activeid:number;
  res1:Observable<Posthistory[]>
  datee
  mb;
  planId;
  activedate;
  name;
  activevalidity;
  demo:any;
  pln=[]
  res:Observable<Posthistory[]>;
  colrtime="text-success"
  msg="Yout Current Plan Expires In ";
  constructor(private _service:RegistrationService,private rout:Router) {
   
   localStorage.setItem('key','8980598756');
     }

  ngOnInit(): void {
    this.mb=localStorage.getItem('key')
    this.load();
  }

  load()
  {
    this.res=this._service.historyPostCustomerFromRemote(this.mb);
    this._service.getpostActiveplan(this.mb).subscribe(
      data=>{
        var str=data.plan_id+''
        localStorage.setItem('postactiveid',str);
        var d=data.edate+''
        localStorage.setItem('postactivedate',d);
        if(data.paid==1)
        {
          console.log("paid")
          this.colrtime="paid"
        }
        else{
          console.log("notpaid")
          this.colrtime="notpaid"
        }
  },
  error=>{
    this.activeid=0;
  });
  }
  
}
