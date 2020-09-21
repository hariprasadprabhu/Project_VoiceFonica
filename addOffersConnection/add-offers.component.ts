import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {AddoffersService} from '../addoffers.service';
import { Offers } from '../offers';

@Component({
  selector: 'app-add-offers',
  templateUrl: './add-offers.component.html',
  styleUrls: ['./add-offers.component.css']
})
export class AddOffersComponent implements OnInit {

  offers=new Offers();

  constructor(private _service: AddoffersService) { }

  ngOnInit(): void {
  }
  addOffer()
  {
    this._service.addOffer(this.offers).subscribe(
      data =>console.log("response received"),
      error=>console.log("exception occured")
    )
  }
}
