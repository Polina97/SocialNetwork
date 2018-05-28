import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {LoginComponent} from '../login/login.component';
import {MainPageComponent} from '../main-page/main-page.component';
import {ProfileComponent} from '../main-page/profile/profile.component';
import {FriendsComponent} from '../main-page/friends/friends.component';
import {GroupsComponent} from '../main-page/groups/groups.component';
import {MessagesComponent} from '../main-page/messages/messages.component';
import {DialogComponent} from '../main-page/messages/dialog/dialog.component';
import {ManageUsersComponent} from '../main-page/manage-users/manage-users.component';

const appRoutes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: '',
    component: MainPageComponent,
    children: [
      {
        path: 'profile',
        component: ProfileComponent
      },
      {
        path: 'friends',
        component: FriendsComponent
      },
      {
        path: 'groups',
        component: GroupsComponent
      },
      {
        path: 'messages',
        component: MessagesComponent
      },
      {
        path: 'messages/dialog',
        component: DialogComponent
      },
      {
        path: 'manage-users',
        component: ManageUsersComponent
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { useHash: true }
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
