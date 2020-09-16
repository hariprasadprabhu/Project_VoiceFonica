import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-answered-query',
  templateUrl: './answered-query.component.html',
  styleUrls: ['./answered-query.component.css']
})
export class AnsweredQueryComponent implements OnInit {

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
