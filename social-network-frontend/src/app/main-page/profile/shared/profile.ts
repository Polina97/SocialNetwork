import {MartialStatus, UserGender} from '../../../shared/constants';
import {WallMessage} from '../../shared/wall-message/wall-message';

export class Profile {
  firstName: string;
  lastName: string;
  birthDay: string;
  userGender: UserGender;
  address: string;
  martialStatus: MartialStatus;
  wallMessages: WallMessage[];
  photoUrl?: string;
}
