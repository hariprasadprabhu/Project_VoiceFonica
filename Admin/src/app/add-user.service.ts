import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, Observable } from 'rxjs';
import {User} from './user'


@Injectable({
  providedIn: 'root'
})
export class AddUserService 
{
 
  constructor(private http:HttpClient) { }

  public call(user:User):Observable<any>
  {
    return this.http.post("http://localhost:8090/addcustomer",user);
  }
   public displayPrepaid():Observable<any>
   {
    
     return this.http.get<any>("http://localhost:8090/viewuser/Prepaid");
   }
 
   public displayPostpaid():Observable<any>
   {
    
     return this.http.get<any>("http://localhost:8090/viewuser/Postpaid");
   }

   public displayDongle():Observable<any>
   {
    
     return this.http.get<any>("http://localhost:8090/viewuser/Dongle");
   }

   public search(num):Observable<any>
   {
     return this.http.get<any>("http://localhost:8090/search/"+num);
   }

   public update(user:User):Observable<any>
   {
     return this.http.post("http://localhost:8090/editcustomer",user);
   }

   public delete(user:User):Observable<any>
   {
     return this.http.post("http://localhost:8090/delcustomer",user);
   }

   public generate(user:User):Observable<any>
   {
     return this.http.post("http://localhost:8090/genpdf",user)
   }

}
