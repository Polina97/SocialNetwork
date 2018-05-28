import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProfileComponent} from './profile.component';
import {SharedModule} from '../shared/shared.module';
import {ButtonModule} from 'primeng/button';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    ButtonModule
  ],
  declarations: [ProfileComponent]
})
export class ProfileModule {
}
