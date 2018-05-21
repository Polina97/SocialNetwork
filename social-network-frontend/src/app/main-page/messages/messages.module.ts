import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MessagesComponent} from './messages.component';
import {DialogComponent} from './dialog/dialog.component';
import {MessagesService} from './shared/messages.service';
import {InputTextareaModule} from 'primeng/primeng';
import {FormsModule} from '@angular/forms';
import {ButtonModule} from 'primeng/button';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    InputTextareaModule,
    ButtonModule
  ],
  declarations: [
    MessagesComponent,
    DialogComponent
  ],
  providers: [MessagesService]
})
export class MessagesModule {
}
