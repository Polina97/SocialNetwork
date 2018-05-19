import {Component, Input, OnInit} from '@angular/core';
import {Profile} from './shared/profile';
import {CookieService} from 'ngx-cookie-service';
import {ProfileService} from './shared/profile.service';
import * as moment from 'moment';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profile: Profile;
  myProfile: boolean;

  private profileId;

  constructor(private cookieService: CookieService,
              private profileService: ProfileService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      if (params['id']) {
        this.profileId = params['id'];
        this.myProfile = this.profileId === this.cookieService.get('profileId');
        this.getProfile();
      } else {
        this.profileId = this.cookieService.get('profileId');
        this.myProfile = true;
        this.getProfile();
      }
    });
  }

  private getProfile(): void {
    this.profileService.getProfileInfo(this.profileId).subscribe(
      res => {
        if (res && res.result === 0) {
          this.profile = res.profile;
          this.profile.birthDay = moment(this.profile.birthDay).format('DD.MM.YYYY');
          if (res.profilePhotos && res.profilePhotos.length > 0) {
            res.profilePhotos.forEach(profilePhoto => {
              if (profilePhoto.current) {
                this.profile.photoUrl = profilePhoto.url;
              }
            });
          }
        }
      }, err => {
        console.log(err);
      }
    );
  }

}
