import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-feedback',
  templateUrl: './customer-feedback.component.html',
  styleUrls: ['./customer-feedback.component.css']
})
export class CustomerFeedbackComponent implements OnInit {
  userData:any=[
    {issue:"not working properly",response:"we will fix soon."},
    {issue:"not working properly",response:"we will fix soon."},
    {issue:"not working properly",response:"we will fix soon."},
    {issue:"not working properly",response:"we will fix soon."}
  ]; 
  
  getInfo(user):void
  {
    console.log(user);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
