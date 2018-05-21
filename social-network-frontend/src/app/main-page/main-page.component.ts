import {Component, OnInit} from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import {Router} from '@angular/router';
import {ProfileService} from './profile/shared/profile.service';
import {Profile} from './profile/shared/profile';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  currentProfile: Profile;
  isAdmin: boolean;

  private userId: string;

  constructor(private cookieService: CookieService,
              private router: Router,
              private profileService: ProfileService) {
    this.userId = this.cookieService.get('userId');
    this.isAdmin = this.cookieService.get('userRoleName') === 'Admin';
  }

  ngOnInit() {
    this.profileService.getProfile(this.userId).subscribe(
      res => {
        if (res && res.result === 0) {
          this.currentProfile = res.profile;
        }
      }, err => {
        console.log(err);
      }
    );
  }

  logout(): void {
    this.cookieService.delete('userId');
    this.router.navigate(['login']);
  }



}
