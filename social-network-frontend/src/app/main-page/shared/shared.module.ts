import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {WallMessageComponent} from './wall-message/wall-message.component';
import {DateFormatPipe} from './date-format.pipe';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    WallMessageComponent,
    DateFormatPipe
  ],
  exports: [WallMessageComponent]
})
export class SharedModule {
}
