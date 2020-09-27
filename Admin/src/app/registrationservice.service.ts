import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Chat } from './chat';
import { Mailinfo } from './mailinfo';
@Injectable({
  providedIn: 'root'
})
export class RegistrationserviceService {

  constructor(private _http:HttpClient) { }

  getChats(phono):Observable<any>{
    return this._http.get<any>("http://localhost:8081/getAlChats/"+phono);
  }
  inserMessage(chat:Chat):Observable<any>{
    return this._http.post<any>("http://localhost:8081/insertChat/",chat);
  }
  //sending mail
  getPostPaidCust():Observable<any>{
    return this._http.get<any>("http://localhost:8081/getallPostpaidPlans");
  }

  getBillPostPaidCust(phno):Observable<any>{
    return this._http.get<any>("http://localhost:8081/getBill/"+phno);
  }

  sendmailabc(mail:Mailinfo):Observable<any>{
    return this._http.post<any>("http://localhost:8083/send-mail",mail);
  }


}
