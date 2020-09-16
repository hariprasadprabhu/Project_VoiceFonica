import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-prepaid',
  templateUrl: './home-prepaid.component.html',
  styleUrls: ['./home-prepaid.component.css']
})
export class HomePrepaidComponent implements OnInit {

  demo:any;
  colrtime="text-success"
  msg="Yout Current Plan Expires In ";
  constructor() { }

  ngOnInit(): void {
  }

  countDouwnDate=new Date("september 15, 2020 22:02:00").getTime();
  x=setInterval(()=>{
    var now = new Date().getTime();
    var distance = this.countDouwnDate-now;
    var days = Math.floor(distance/(1000*60*60*24));
    var hours = Math.floor((distance%(1000*60*60*24))/(1000*60*60));
    var minutes = Math.floor((distance%(1000*60*60))/(1000*60));
    var seconds = Math.floor((distance%(1000*60))/(1000));
    this.demo = days + " Days "+hours+" Hours "+minutes+" Minutes "+seconds+" Seconds";
    if(distance<86400000)
    {
      this.colrtime= "text-danger";
    }
    if(distance<0)
    {
      clearInterval(this.x)
      this.demo="Your plan is expired"
      this.colrtime= "text-danger";
      this.msg="Oops...!!"
    }
  })
}
