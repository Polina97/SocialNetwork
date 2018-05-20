import {Component, OnInit} from '@angular/core';
import {Profile} from '../profile/shared/profile';
import {FriendsService} from './shared/friends.service';
import {CookieService} from 'ngx-cookie-service';
import {SearchFriend} from './shared/search-friend';
import {CALENDAR_RU, MartialStatus} from '../../shared/constants';
import {SelectItem} from 'primeng/api';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {
  friends: Profile[];
  searchFriend: SearchFriend;
  ru: any;
  martialStatuses: SelectItem[];

  private myProfileId: string;

  constructor(private friendsService: FriendsService,
              private cookieService: CookieService) {
    this.searchFriend = new SearchFriend();
    this.ru = CALENDAR_RU;
    this.martialStatuses = [
      {label: 'Не определён', value: MartialStatus.NONE},
      {label: 'Без пары', value: MartialStatus.SINGLE},
      {label: 'С парой', value: MartialStatus.ENGAGED},
      {label: 'В браке', value: MartialStatus.MARRIED}
    ];
  }

  ngOnInit() {
    this.myProfileId = this.cookieService.get('profileId');
    this.getFriends();
  }

  findFriends(): void {
    this.friends = [];
    this.friendsService.findFriends(this.myProfileId, this.searchFriend).subscribe(
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
