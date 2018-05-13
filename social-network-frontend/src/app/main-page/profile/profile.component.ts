import {Component, OnInit} from '@angular/core';
import {Profile} from './shared/profile';
import {CookieService} from 'ngx-cookie-service';
import {ProfileService} from './shared/profile.service';
import * as moment from 'moment';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profile: Profile;

  private userId: string;

  constructor(private cookieService: CookieService,
              private profileService: ProfileService) {
    this.userId = this.cookieService.get('userId');
  }

  ngOnInit() {
    this.profileService.getProfile(this.userId).subscribe(
      res => {
        if (res && res.result === 0) {
          this.profile = res.profile;
          this.profile.wallMessages = res.wallMessages;
          this.profile.birthDay = moment(this.profile.birthDay).format('DD.MM.YYYY');
          this.profile.photoUrl = res.photoUrl;
        }
      }, err => {
        console.log(err);
      }
    );
  }

}
