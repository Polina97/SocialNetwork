import {Component} from '@angular/core';
import {LoginService} from './login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  login: string;
  password: string;

  constructor(private loginService: LoginService,
              private router: Router) {
  }

  makeLogin(): void {
    this.loginService.loginRequest(this.login, this.password).subscribe(
      res => {
        if (res && res.result === 0) {
          this.router.navigate(['main-page'], {queryParams: { id: res.userId }});
        }
      }, err => {
        console.log(err);
      }
    );
  }
}
