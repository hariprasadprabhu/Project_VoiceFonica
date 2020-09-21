import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Offers } from './offers';

@Injectable({
  providedIn: 'root'
})
export class AddoffersService {

  constructor(private _http: HttpClient) { }

  public addOffer(offer: Offers):Observable<any>
  {
    return this._http.post<any>("http://localhost:8090/addoffer",offer)
  }
}
