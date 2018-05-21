import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SearchFriend} from './search-friend';
import * as moment from 'moment';
import {FriendshipStatus} from '../../../shared/constants';

@Injectable({
  providedIn: 'root'
})
export class FriendsService {
  private friendsUrl = 'friends';
  private messageUrl = 'message';

  constructor(private http: HttpClient) {
  }

  getFriendsByStatus(profileId: string, friendshipStatus: FriendshipStatus): Observable<any> {
    return this.http.post(this.friendsUrl + '/getByFriendshipStatus', null, {
      params: new HttpParams()
        .set('profileId', profileId)
        .set('friendshipStatus', friendshipStatus.toString())
    });
  }

  findFriends(profileId: string, searchFriend: SearchFriend): Observable<any> {
    let params = new HttpParams()
      .set('profileId', profileId);

    if (searchFriend.name && searchFriend.name !== '') params = params.set('name', searchFriend.name);
    if (searchFriend.bDayRange && searchFriend.bDayRange.length > 0) {
      params = params.set('bDayStart', moment(searchFriend.bDayRange[0]).format('DD.MM.YYYY'));
      const endDate = (searchFriend.bDayRange.length > 1 && searchFriend.bDayRange[1]) ? searchFriend.bDayRange[1] : Date.now();
      params = params.set('bDayEnd', moment(endDate).format('DD.MM.YYYY'));
    }
    if (searchFriend.gender) params = params.set('gender', searchFriend.gender.toString());
    if (searchFriend.martialStatus) params = params.set('martialStatus', searchFriend.martialStatus.toString());

    return this.http.post(this.friendsUrl + '/findFriends', null, {
      params: params
    });
  }

  addToFriends(profileId: string, friendId: string, friendshipStatus: FriendshipStatus): Observable<any> {
    return this.http.post(this.friendsUrl + '/addToFriends', null, {
      params: new HttpParams()
        .set('profileId', profileId)
        .set('friendId', friendId)
        .set('friendshipStatus', friendshipStatus.toString())
    });
  }

  deleteFriendship(profileId: string, friendId: string): Observable<any> {
    return this.http.post(this.friendsUrl + '/deleteFriendship', null, {
      params: new HttpParams()
        .set('profileId', profileId)
        .set('friendId', friendId)
    });
  }

  writeMessage(profileId: string, friendId: string, message: string): Observable<any> {
    return this.http.post(this.messageUrl + '/writeMessage', null, {
      params: new HttpParams()
        .set('ownerId', profileId)
        .set('targetId', friendId)
        .set('message', message)
    });
  }
}
