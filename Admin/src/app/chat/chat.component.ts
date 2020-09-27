import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { RegistrationserviceService } from '../registrationservice.service'
import { Chat } from '../chat'

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  chats:Observable<Chat>;
  chat=new Chat();
  mob
  constructor(private _service:RegistrationserviceService) { 
    this.mob=9980598756
  }

  ngOnInit(): void {
    this.load()
  }

  load()
  {
    this.chats=this._service.getChats(this.mob)
    this.chat.phone_num=9980598756;
    this.chat.admin_id=1;
  }
  call()
  {
    this._service.inserMessage(this.chat).subscribe(
      data=>
      {
        this.load();

      }
    );
  }
  x=setInterval(()=>{
    this.load();
  },10000)
}
