import {Component} from '@angular/core';
import {LoginService} from './login.service';
import {Router} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  login: string;
  password: string;

  constructor(private loginService: LoginService,
              private router: Router,
              private cookieService: CookieService) {
  }

  makeLogin(): void {
    this.loginService.loginRequest(this.login, this.password).subscribe(
      res => {
        if (res && res.result === 0) {
          this.cookieService.set('userId', res.user.userId);
          this.router.navigate(['profile'], {queryParams: {id: res.user.profile.profileId}});
        }
      }, err => {
        console.log(err);
      }
    );
  }
}
