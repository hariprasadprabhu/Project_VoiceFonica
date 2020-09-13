import { Injectable } from '@angular/core';
import {Admin} from './admin';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http:HttpClient) { }

  public storeDetails(admin :Admin):Observable<any>
  {
    return this.http.post("http://localhost:8090/reg",admin);
  }
}
