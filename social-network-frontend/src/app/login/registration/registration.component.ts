import {Component} from '@angular/core';
import {Registration} from './registration';
import {LoginService} from '../login.service';
import {ConfirmationService} from 'primeng/api';
import {CALENDAR_RU} from '../../shared/constants';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  providers: [ConfirmationService]
})
export class RegistrationComponent{
  registration: Registration;
  ru: any;

  constructor(private loginService: LoginService,
              private confirmationService: ConfirmationService) {
    this.registration = new Registration();
    this.ru = CALENDAR_RU;
  }

  register(): void {
    this.loginService.register(this.registration).subscribe(
      res => {
        if (res && res.result === 0) {
          this.openConfirm();
        }
      }
    );
  }

  openConfirm() {
    this.confirmationService.confirm({
      message: 'Вы зарегистрированы, тепрь вы можете войти.',
      accept: () => {
        this.loginService.goToLogin();
      }
    });
  }
}
