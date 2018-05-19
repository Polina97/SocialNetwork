import {UserGender} from '../../shared/constants';

export class Registration {
  email: string;
  password: string;
  repeatPassword: string;
  firstName: string;
  lastName: string;
  birthDate: Date;
  gender: UserGender;

  constructor() {
    this.gender = UserGender.MALE;
  }
}
