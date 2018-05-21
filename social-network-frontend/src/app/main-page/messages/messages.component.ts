import {Component, OnInit} from '@angular/core';
import {MessagesService} from './shared/messages.service';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  myProfileId: string;

  constructor(private messagesService: MessagesService,
              private cookieService: CookieService) {
  }

  ngOnInit() {
    this.myProfileId = this.cookieService.get('profileId');
    this.messagesService.getDialogs(this.myProfileId).subscribe(
      res => {
        console.log(res);
        if (res && res.result === 0) {

        }
      }
    );
  }

}
