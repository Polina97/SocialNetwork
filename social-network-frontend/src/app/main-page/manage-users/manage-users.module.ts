import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TableModule} from 'primeng/table';
import {ManageUsersComponent} from './manage-users.component';
import {CheckboxModule, ConfirmDialogModule} from 'primeng/primeng';
import {ButtonModule} from 'primeng/button';
import {FormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    TableModule,
    ConfirmDialogModule,
    CheckboxModule,
    ButtonModule,
    FormsModule
  ],
  declarations: [ManageUsersComponent]
})
export class ManageUsersModule {
}
