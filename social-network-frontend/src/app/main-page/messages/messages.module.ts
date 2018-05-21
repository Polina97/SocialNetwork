import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MessagesComponent} from './messages.component';
import {DialogComponent} from './dialog/dialog.component';
import {MessagesService} from './shared/messages.service';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    MessagesComponent,
    DialogComponent
  ],
  providers: [MessagesService]
})
export class MessagesModule {
}
