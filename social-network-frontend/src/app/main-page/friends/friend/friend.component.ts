import {Component, Input, OnInit} from '@angular/core';
import {Profile} from '../../profile/shared/profile';

@Component({
  selector: 'app-friend',
  templateUrl: './friend.component.html',
  styleUrls: ['./friend.component.css']
})
export class FriendComponent implements OnInit {
  @Input() friend: Profile;
  @Input() isFriend: boolean;

  constructor() {
  }

  ngOnInit() {
  }

}
