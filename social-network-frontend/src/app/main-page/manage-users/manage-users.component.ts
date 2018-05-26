import {AfterViewChecked, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {User} from './user';
import {MainPageService} from '../shared/main-page.service';
import {ConfirmationService} from 'primeng/api';

@Component({
  selector: 'app-manage-users',
  templateUrl: './manage-users.component.html',
  styleUrls: ['./manage-users.component.css'],
  providers: [ConfirmationService]
})
export class ManageUsersComponent implements OnInit, AfterViewChecked {
  cols: any[];
  users: User[];
  showTable: boolean;
  display: boolean;

  constructor(private mainPageService: MainPageService,
              private confirmationService: ConfirmationService,
              private ref: ChangeDetectorRef) {
    this.showTable = false;
    this.display = false;
    this.cols = [
      { field: 'login', header: 'Login' },
      { field: 'blocked', header: 'Blocked' }
    ];
  }

  ngOnInit() {
    this.mainPageService.getSimpleUsers().subscribe(
      res => {
        if (res && res.result === 0) {
          this.users = res.users;
          this.showTable = true;
        }
      }
    );
  }

  ngAfterViewChecked() {
    this.ref.detectChanges();
  }

  showDialog(user: User) {
    this.confirmationService.confirm({
      // when action called, value already changed
      message: 'Вы хотите ' + (user.blocked ? 'заблокировать' : 'разблокировать')  + ' пользователя ' + user.login + '?',
      accept: () => {
        this.mainPageService.changeUserInfo(user).subscribe(
          res => {
            if (res && res.result !== 0) {
              user.blocked = !user.blocked;
            }
          }
        );
      },
      reject: () => {
        user.blocked = !user.blocked;
      }
    });
  }
}
