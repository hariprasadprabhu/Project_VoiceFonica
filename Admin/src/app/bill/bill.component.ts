import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import {CustSub} from '../cust-sub'
import { RegistrationserviceService } from '../registrationservice.service';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {

  cust:Observable<CustSub[]>
  constructor(private _service: RegistrationserviceService,private _router:Router) { 
    this._service.getPostPaidCust().subscribe(
      data=>{
        this.cust=data;
      },
      error=>{
        console.log("errror occurd");
      }
    )
  }

  ngOnInit(): void {

  }
  generate(val)
  {
    let str=''+val
    localStorage.setItem('mob',str);
    this._router.navigate(['/pdfgen'])
  }

}
