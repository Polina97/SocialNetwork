import {Component} from '@angular/core';
import {Registration} from './registration';
import {LoginService} from '../login.service';
import {ConfirmationService} from 'primeng/api';

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
    this.ru = {
      firstDayOfWeek: 1,
      dayNames: ['Воскресенье', 'Понедельник', 'Вторник', 'Среда', 'Четверг', 'Пятница', 'Суббота'],
      dayNamesShort: ['ВС', 'ПН', 'ВТ', 'СР', 'ЧТ', 'ПТ', 'СБ'],
      dayNamesMin: ['ВС', 'ПН', 'ВТ', 'СР', 'ЧТ', 'ПТ', 'СБ'],
      monthNames: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'],
      monthNamesShort: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'],
      today: 'Сегодня',
      clear: 'Очистить'
    };
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
