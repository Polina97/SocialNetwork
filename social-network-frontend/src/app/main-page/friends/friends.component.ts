import {Component, OnInit} from '@angular/core';
import {Profile} from '../profile/shared/profile';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {
  friends: Profile[];
  searchValue: string;

  constructor() {
  }

  ngOnInit() {
  }

  findFriends(): void {

  }

}
