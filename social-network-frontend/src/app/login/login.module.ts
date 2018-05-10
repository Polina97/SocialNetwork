import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ButtonModule, InputTextModule} from 'primeng/primeng';

import {LoginComponent} from './login.component';
import {LoginService} from './login.service';
import {FormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    InputTextModule,
    ButtonModule,
    FormsModule
  ],
  declarations: [LoginComponent],
  providers: [LoginService],
  exports: [LoginComponent]
})
export class LoginModule {
}
