import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MainPageComponent} from './main-page.component';
import {ProfileModule} from './profile/profile.module';
import {RouterModule} from '@angular/router';
import {FriendsModule} from './friends/friends.module';
import {GroupsModule} from './groups/groups.module';
import {MessagesModule} from './messages/messages.module';
import {PhotosComponent} from './photos/photos.component';
import {ButtonModule} from 'primeng/button';

@NgModule({
  imports: [
    CommonModule,
    ProfileModule,
    FriendsModule,
    GroupsModule,
    MessagesModule,
    RouterModule,
    ButtonModule
  ],
  declarations: [
    MainPageComponent,
    PhotosComponent
  ]
})
export class MainPageModule {
}
