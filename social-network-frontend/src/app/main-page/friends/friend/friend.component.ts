import {Component, Input, OnInit} from '@angular/core';
import {Profile} from '../../profile/shared/profile';
import {Router} from '@angular/router';
import {FriendshipStatus} from '../../../shared/constants';

@Component({
  selector: 'app-friend',
  templateUrl: './friend.component.html',
  styleUrls: ['./friend.component.css']
})
export class FriendComponent implements OnInit {
  @Input() friend: Profile;
  @Input() friendshipStatus: FriendshipStatus;
  @Input() isRequest: boolean;

  friendshipStatuses = FriendshipStatus;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  goToFriend() {
    this.router.navigate(['profile'], {queryParams: {id: this.friend.profileId}});
  }

}
