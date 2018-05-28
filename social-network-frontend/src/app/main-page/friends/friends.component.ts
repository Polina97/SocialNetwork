import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {Profile} from '../profile/shared/profile';
import {FriendsService} from './shared/friends.service';
import {CookieService} from 'ngx-cookie-service';
import {SearchFriend} from './shared/search-friend';
import {CALENDAR_RU, FriendshipStatus, MartialStatus} from '../../shared/constants';
import {SelectItem} from 'primeng/api';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class FriendsComponent implements OnInit {
  friends: Profile[];
  friendRequests: Profile[];
  subscribers: Profile[];
  searchFriend: SearchFriend;
  ru: any;
  martialStatuses: SelectItem[];
  friendshipStatuses = FriendshipStatus;
  myProfileId: string;

  private currentIndex: number;

  constructor(private friendsService: FriendsService,
              private cookieService: CookieService) {
    this.searchFriend = new SearchFriend();
    this.ru = CALENDAR_RU;
    this.currentIndex = 0;
    this.martialStatuses = [
      {label: 'Не определён', value: MartialStatus.NONE},
      {label: 'Без пары', value: MartialStatus.SINGLE},
      {label: 'С парой', value: MartialStatus.ENGAGED},
      {label: 'В браке', value: MartialStatus.MARRIED}
    ];
  }

  ngOnInit() {
    this.myProfileId = this.cookieService.get('profileId');
    this.getFriends(FriendshipStatus.FRIEND);
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
    this.currentIndex = index;
    if (index === 0) {
      this.getFriends(FriendshipStatus.FRIEND);
    } else if (index === 1){
      this.findFriends();
    } else {
      this.getFriends(FriendshipStatus.SUBSCRIBER);
    }
  }

  handleFriendshipChange(): void {
    this.tabChangeHandler(this.currentIndex);
  }

  private getFriends(friendshipStatus: FriendshipStatus): void {
    this.friends = [];
    this.friendsService.getFriendsByStatus(this.myProfileId, friendshipStatus).subscribe(
      res => {
        if (res && res.result === 0) {
          if (res.friends) {
            this.friends = res.friends;
          } else {
            this.friendRequests = res.requests;
            this.subscribers = res.subscribers;
          }
        }
      }
    );
  }

}
