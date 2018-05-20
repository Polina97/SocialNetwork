import {Component, Input, OnInit} from '@angular/core';
import {Profile} from '../../profile/shared/profile';
import {Router} from '@angular/router';

@Component({
  selector: 'app-friend',
  templateUrl: './friend.component.html',
  styleUrls: ['./friend.component.css']
})
export class FriendComponent implements OnInit {
  @Input() friend: Profile;
  @Input() isFriend: boolean;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  goToFriend() {
    this.router.navigate(['profile'], {queryParams: {id: this.friend.profileId}});
  }

}
