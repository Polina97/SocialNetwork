import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private profileUrl = 'profile';

  constructor(private http: HttpClient) {
  }

  getProfileInfo(profileId: string): Observable<any> {
    return this.http.post(this.profileUrl + '/getProfile', null, {
      params: new HttpParams()
        .set('profileId', profileId)
    });
  }

  getProfile(userId: string): Observable<any> {
    return this.http.post(this.profileUrl + '/getByUserId', null, {
      params: new HttpParams()
        .set('userId', userId)
    });
  }


}
