import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {
  ButtonModule,
  CalendarModule,
  InputTextModule,
  PasswordModule,
  RadioButtonModule,
  SelectButtonModule,
  ConfirmDialogModule
} from 'primeng/primeng';

import {LoginComponent} from './login.component';
import {LoginService} from './login.service';
import {FormsModule} from '@angular/forms';
import {RegistrationComponent} from './registration/registration.component';

@NgModule({
  imports: [
    CommonModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    PasswordModule,
    RadioButtonModule,
    CalendarModule,
    SelectButtonModule,
    ConfirmDialogModule
  ],
  declarations: [
    LoginComponent,
    RegistrationComponent
  ],
  providers: [LoginService],
  exports: [LoginComponent]
})
export class LoginModule {
}
