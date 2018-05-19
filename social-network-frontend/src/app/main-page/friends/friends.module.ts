import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FriendsComponent} from './friends.component';
import {FriendComponent} from './friend/friend.component';
import {TabViewModule} from 'primeng/primeng';
import {FormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    TabViewModule,
    FormsModule
  ],
  declarations: [
    FriendsComponent,
    FriendComponent
  ]
})
export class FriendsModule {
}
