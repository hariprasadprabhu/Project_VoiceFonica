import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-headernav-prepaid',
  templateUrl: './headernav-prepaid.component.html',
  styleUrls: ['./headernav-prepaid.component.css']
})
export class HeadernavPrepaidComponent implements OnInit {

  phno;
  constructor() { 
    this.phno=localStorage.getItem('key');
  }

  ngOnInit(): void {
  }

}
