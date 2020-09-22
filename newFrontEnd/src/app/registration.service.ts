import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Customer} from './customer';
import {Plans} from './plans';
import {HttpClient} from '@angular/common/http';
import { Query } from './query';
import { Details } from './details';
import { Chat } from './chat';
import { Activeplans } from './activeplans';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  
  sharedId:number;

  setmob(data)
  {
    this.sharedId=data;
  }
  getmob()
  {
    return this.sharedId;
  }

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
  queryCustomerFromRemote(phno): Observable<Query[]> {
    return  this._http.get<any>("http://localhost:8081/query/"+phno);
  }
  historyCustomerFromRemote(phno): Observable<Details[]> {
    return  this._http.get<any>("http://localhost:8081/history/"+phno);
  }
  getPlanIdFromRemote(pid):Observable<Plans[]>{
    return this._http.get<any[] >("http://localhost:8081/getplan/"+pid);
  }
  getActivePlanFromRemote(pid):Observable<any>{
    return this._http.get<any>("http://localhost:8081/getActiveplan/"+pid)
    
  }
  getDatePlanFromRemote(phno):Observable<any>{
    return this._http.get<any>("http://localhost:8081/getActiveplanDate/"+phno);
  }
  getChats(phono):Observable<any>{
    return this._http.get<any>("http://localhost:8081/getAllChats/"+phono);
  }
  inserMessage(chat:Chat):Observable<any>{
    return this._http.post<any>("http://localhost:8081/insertChats/",chat);
  }
  updateActivePlanq(phno:Activeplans):Observable<any>{
    return this._http.post<any>("http://localhost:8081/updateActivePlan",phno);
  }
}
