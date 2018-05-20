import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserGender} from '../../../shared/constants';

@Injectable({
  providedIn: 'root'
})
export class FriendsService {
  private friendsUrl = 'friends';

  constructor(private http: HttpClient) {
  }

  getFriends(profileId: string): Observable<any> {
    return this.http.post(this.friendsUrl + '/getFriends', null, {
      params: new HttpParams()
        .set('profileId', profileId)
    });
  }

  findFriends(profileId: string, name: string, birthDay: string, gender: string): Observable<any> {
    return this.http.post(this.friendsUrl + '/findFriends', null, {
      params: new HttpParams()
        .set('profileId', profileId)
        .set('name', name)
        .set('birthDay', birthDay)
        .set('gender', gender)
    });
  }
}
