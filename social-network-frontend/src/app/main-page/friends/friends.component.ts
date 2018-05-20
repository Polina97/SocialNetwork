import {Component, OnInit} from '@angular/core';
import {Profile} from '../profile/shared/profile';
import {FriendsService} from './shared/friends.service';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {
  friends: Profile[];
  searchValue: string;

  private myProfileId: string;

  constructor(private friendsService: FriendsService,
              private cookieService: CookieService) {
  }

  ngOnInit() {
    this.myProfileId = this.cookieService.get('profileId');
    this.getFriends();
  }

  findFriends(): void {
    this.friends = [];
    this.friendsService.findFriends(this.myProfileId, '', '', '').subscribe(
      res => {
        if (res && res.result === 0) {
          this.friends = res.notFriends;
        }
      }
    );
  }

  tabChangeHandler(index: number): void {
    if (index === 0) {
      this.getFriends();
    } else {
      this.findFriends();
    }
  }

  private getFriends(): void {
    this.friends = [];
    this.friendsService.getFriends(this.myProfileId).subscribe(
      res => {
        if (res && res.result === 0) {
          this.friends = res.friends;
        }
      }
    );
  }

}
