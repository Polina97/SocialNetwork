import {Component} from '@angular/core';
import {LoginService} from './login.service';
import {Router} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';
import {SelectItem} from 'primeng/api';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  login: string;
  password: string;
  types: SelectItem[];
  selectedType: number;
  showLogin: boolean;

  constructor(private loginService: LoginService,
              private router: Router,
              private cookieService: CookieService) {
    this.loginService.successfulRegistration.subscribe(() => this.handleCompleteRegistration());
    this.showLogin = true;
    this.types = [
      {label: 'Вход', value: 0},
      {label: 'Регистрация', value: 1}
    ];
    this.selectedType = 0;
  }

  makeLogin(): void {
    this.loginService.loginRequest(this.login, this.password).subscribe(
      res => {
        if (res && res.result === 0) {
          this.cookieService.set('userId', res.user.userId);
          this.cookieService.set('profileId', res.user.profile.profileId);
          this.cookieService.set('userRoleName', res.user.userRole.userRoleName);
          this.router.navigate(['profile'], {queryParams: {id: res.user.profile.profileId}});
        }
      }, err => {
        console.log(err);
      }
    );
  }

  handleTypeChange(): void {
    if (this.selectedType === 0) {
      this.showLogin = true;
    } else {
      this.showLogin = false;
      this.login = '';
      this.password = '';
    }
  }

  handleCompleteRegistration(): void {
    this.selectedType = 0;
    this.showLogin = true;
  }
}
