import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {AddUserService} from '../add-user.service';
import { User } from '../user';
import {FormGroup, FormsModule, NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { Location } from '@angular/common';


@Component({
  selector: 'app-admin-postpaid-customer',
  templateUrl: './admin-postpaid-customer.component.html',
  styleUrls: ['./admin-postpaid-customer.component.css']
})
export class AdminPostpaidCustomerComponent implements OnInit {
  customers : Observable<User[]>;
  customerForm:FormGroup;
  user=new User();
  constructor(private service:AddUserService,private router:Router) { }

  ngOnInit(): void 
  {
    this.initialize();
    this.reloadData();
  }


  initialize()
  {
    
    this.customers=this.service.displayPostpaid();
   
  }

  reloadData()
  {
    this.customers=this.service.displayPostpaid();
  }

  update(cust)
  {
    this.user=cust;
    this.service.update(this.user).subscribe(
      data=>{console.log("response recived"),
      window.location.reload();

    },
      error=>{console.log("exception occured")}
      
    

    );
  }

  delete(cust)
  {
    this.user=cust;
    this.service.delete(this.user).subscribe(
      data=>{console.log("response recived"),
      this.reloadData();

    },
      error=>{console.log("exception occured")}
    
    );

  }

  generateBill(cust)
  {
    this.user=cust;
    this.service.generate(this.user).subscribe(
      data=>{console.log("response recived")
      

    },
      error=>{console.log("exception occured")}
    
    );

  }


}
