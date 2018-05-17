import {MartialStatus, UserGender} from '../../../shared/constants';
import {WallMessage} from '../../shared/wall-message/wall-message';
import {ProfilePhoto} from '../../photos/profile-photo';

export class Profile {
  firstName: string;
  lastName: string;
  birthDay: string;
  userGender: UserGender;
  address: string;
  martialStatus: MartialStatus;
  wallMessages: WallMessage[];
  profilePhotos?: ProfilePhoto[];
  photoUrl?: string;
}
