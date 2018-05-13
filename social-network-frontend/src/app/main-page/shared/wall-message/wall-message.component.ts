import {Component, Input, OnInit} from '@angular/core';
import {WallMessage} from './wall-message';

@Component({
  selector: 'app-wall-message',
  templateUrl: './wall-message.component.html',
  styleUrls: ['./wall-message.component.css']
})
export class WallMessageComponent implements OnInit {
  @Input() wallMessage: WallMessage;

  constructor() {
  }

  ngOnInit() {
  }

}
