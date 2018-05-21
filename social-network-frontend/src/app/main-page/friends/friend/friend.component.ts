import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Profile} from '../../profile/shared/profile';
import {Router} from '@angular/router';
import {FriendshipStatus} from '../../../shared/constants';
import {FriendsService} from '../shared/friends.service';
import {ConfirmationService} from 'primeng/api';
import {Message} from '../../messages/shared/message';

@Component({
  selector: 'app-friend',
  templateUrl: './friend.component.html',
  styleUrls: ['./friend.component.css']
})
export class FriendComponent implements OnInit {
  @Input() friend: Profile;
  @Input() friendshipStatus: FriendshipStatus;
  @Input() isRequest: boolean;
  @Input() currentProfileId: string;
  @Output() friendshipChanged: EventEmitter<any> = new EventEmitter<any>();

  friendshipStatuses = FriendshipStatus;
  message: Message;

  constructor(private router: Router,
              private friendsService: FriendsService) {
    this.message = new Message();
  }

  ngOnInit() {
  }

  goToFriend() {
    this.router.navigate(['profile'], {queryParams: {id: this.friend.profileId}});
  }

  addOrAcceptFriend(isAdd: boolean): void {
    const status = (isAdd) ? FriendshipStatus.SUBSCRIBER : FriendshipStatus.FRIEND;
    this.friendsService.addToFriends(this.currentProfileId, this.friend.profileId.toString(), status).subscribe(
      res => {
        if (res && res.result === 0) {
          this.friendshipChanged.emit();
        }
      }
    );
  }

  deleteFriendship(): void {
    this.friendsService.deleteFriendship(this.currentProfileId, this.friend.profileId.toString()).subscribe(
      res => {
        if (res && res.result === 0) {
          this.friendshipChanged.emit();
        }
      }
    );
  }

  sendMessage(overlayPanel:any): void {
    this.friendsService.writeMessage(this.currentProfileId, this.friend.profileId.toString(), this.message.message).subscribe(
      res => {
        if (res && res.result === 0) {
          overlayPanel.hide();
        }
      }
    );
  }

}
