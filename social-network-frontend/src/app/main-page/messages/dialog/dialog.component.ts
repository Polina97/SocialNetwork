import {Component, OnInit} from '@angular/core';
import {Message} from '../shared/message';
import {MessagesService} from '../shared/messages.service';
import {ActivatedRoute} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {
  currentProfileId: string;
  targetProfileId: string;
  messages: Message[];
  newMessage: Message;

  constructor(private messagesService: MessagesService,
              private route: ActivatedRoute,
              private cookieService: CookieService) {
    this.newMessage = new Message();
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      if (params['id']) {
        this.targetProfileId = params['id'];
        this.currentProfileId = this.cookieService.get('profileId');
        this.getAllMessages();
      }
    });

  }

  getAllMessages(): void {
    this.messagesService.getAllMessages(this.currentProfileId, this.targetProfileId).subscribe(
      res => {
        if (res && res.result === 0) {
          this.messages = res.messages;
        }
      }
    );
  }

  sendMessage(overlayPanel:any): void {
    this.messagesService.writeMessage(this.currentProfileId, this.targetProfileId, this.newMessage.message).subscribe(
      res => {
        if (res && res.result === 0) {
          this.getAllMessages();
        }
      }
    );
  }

}
