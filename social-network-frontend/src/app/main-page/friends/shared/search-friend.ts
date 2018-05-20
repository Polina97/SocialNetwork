import {MartialStatus, UserGender} from '../../../shared/constants';

export class SearchFriend {
  name: string;
  gender: UserGender;
  martialStatus: MartialStatus;
  bDayRange: Date[];
}
