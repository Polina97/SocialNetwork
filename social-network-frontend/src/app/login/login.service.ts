import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private userUrl = 'user';
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) {
  }

  loginRequest(login: string, password: string): Observable<any> {
    return this.http.post(this.userUrl + '/login', null, {
      params: new HttpParams()
        .set('login', login)
        .set('password', password)
    });
  }
}
