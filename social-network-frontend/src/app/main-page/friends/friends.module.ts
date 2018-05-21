import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FriendsComponent} from './friends.component';
import {FriendComponent} from './friend/friend.component';
import {CalendarModule, DropdownModule, InputTextareaModule, OverlayPanelModule, RadioButtonModule, TabViewModule} from 'primeng/primeng';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {FriendsService} from './shared/friends.service';
import {ButtonModule} from 'primeng/button';

@NgModule({
  imports: [
    CommonModule,
    TabViewModule,
    FormsModule,
    RouterModule,
    ButtonModule,
    RadioButtonModule,
    CalendarModule,
    DropdownModule,
    OverlayPanelModule,
    InputTextareaModule
  ],
  declarations: [
    FriendsComponent,
    FriendComponent
  ],
  providers:[FriendsService]
})
export class FriendsModule {
}
