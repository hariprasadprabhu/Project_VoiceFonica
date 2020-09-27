import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import * as firebase from 'firebase'

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrls: ['./otp.component.css']
})
export class OtpComponent implements OnInit {
  toggle=false
  event;
  code;
  constructor() { }
  
  ngOnInit() {
    const firebaseConfig = {
      apiKey: "AIzaSyC6u0bOCITXdLvNQszLUCGSkFDWbpqddtk",
      authDomain: "otp-generator-ac884.firebaseapp.com",
      databaseURL: "https://otp-generator-ac884.firebaseio.com",
      projectId: "otp-generator-ac884",
      storageBucket: "otp-generator-ac884.appspot.com",
      messagingSenderId: "585045980602",
      appId: "1:585045980602:web:8f548b13daa06fa7e45983",
      measurementId: "G-NY9Y10Z8YW"
    };
    firebase.initializeApp(firebaseConfig)
    }
      otp(){
    console.log("hello")
    let recaption=new firebase.auth.RecaptchaVerifier('recaptcha')
    let number='+919980598756';
    firebase.auth().signInWithPhoneNumber(number,recaption).then(async (e)=>{
      this.event=e
      this.toggle=true;
    })
  }
  verify(){
    this.event.confirm(this.code).then(res=>{
      alert(`${res.user.phoneNumber} is verified`)
    })
    .catch(err=>{
      alert("Wrong OTP")
    })
  }
}
