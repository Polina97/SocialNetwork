import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {MessagesService} from './shared/messages.service';
import {CookieService} from 'ngx-cookie-service';
import {Profile} from '../profile/shared/profile';
import {Router} from '@angular/router';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class MessagesComponent implements OnInit {
  myProfileId: string;
  profiles: Profile[];

  constructor(private messagesService: MessagesService,
              private cookieService: CookieService,
              private router: Router,) {
  }

  ngOnInit() {
    this.myProfileId = this.cookieService.get('profileId');
    this.messagesService.getDialogs(this.myProfileId).subscribe(
      res => {
        if (res && res.result === 0) {
          this.profiles = res.profiles;
        }
      }
    );
  }

  goToDialog(targetId: string): void {
    this.router.navigate(['messages/dialog'], {queryParams: {id: targetId}});
  }

}
