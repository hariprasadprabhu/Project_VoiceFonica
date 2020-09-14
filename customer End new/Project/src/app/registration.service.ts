import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Customer} from './customer';
import {Plans} from './plans';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http:HttpClient) {
  }
  loginCustomerFromRemote(cust:Customer):Observable<any>
  {
   return  this._http.post<any>("http://localhost:8081/login",cust);
  }
  registerCustomerFromRemote(cust:Customer):Observable<any>
  {
   return  this._http.post<any>("http://localhost:8081/registercustomer",cust);
  }
  plansPrepaidCustomerFromRemote():Observable<any>
  {
   return  this._http.get<any>("http://localhost:8081/getallPlans");
  }
}
