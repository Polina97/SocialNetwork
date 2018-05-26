import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../manage-users/user';
import * as _ from 'lodash';

@Injectable({
  providedIn: 'root'
})
export class MainPageService {
  private userUrl = 'user';

  constructor(private http: HttpClient) {
  }

  getSimpleUsers(): Observable<any> {
    return this.http.get(this.userUrl + '/getSimpleUsers');
  }

  changeUserInfo(user: User): Observable<any> {
    let params = new HttpParams().set('id', user.userId.toString());

    if (user.email) params = params.set('email', user.email);
    if (user.password) params = params.set('password', user.password);
    if (!_.isNil(user.blocked)) params = params.set('blocked', '' + user.blocked);

    return this.http.post(this.userUrl + '/changeUserInfo', null, {
      params: params
    });
  }
}
