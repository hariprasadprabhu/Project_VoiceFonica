import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-notanswered-query',
  templateUrl: './notanswered-query.component.html',
  styleUrls: ['./notanswered-query.component.css']
})
export class NotansweredQueryComponent implements OnInit {
  title='pro1';
  userData:any=[
    {issue:"not working properly",response:"we will fix soon."},
    {issue:"not working properly",response:"we will fix soon."},
    {issue:"not working properly",response:"we will fix soon."},
    {issue:"not working properly",response:"we will fix soon."}
  ];

  constructor() { }

  Reply()
  {
    
  }

  ngOnInit(): void {
  }

}
