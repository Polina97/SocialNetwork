import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, Subject} from 'rxjs';
import {Registration} from './registration/registration';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  successfulRegistration: Subject<any> = new Subject();

  private userUrl = 'user';

  constructor(private http: HttpClient) {
  }

  loginRequest(login: string, password: string): Observable<any> {
    return this.http.post(this.userUrl + '/login', null, {
      params: new HttpParams()
        .set('login', login)
        .set('password', password)
    });
  }

  register(registration: Registration): Observable<any> {
    return this.http.post(this.userUrl + '/register', null, {
      params: new HttpParams()
        .set('email', registration.email)
        .set('firstName', registration.firstName)
        .set('lastName', registration.lastName)
        .set('gender', registration.gender.toString())
        .set('birthDate', registration.birthDate.toString())
        .set('password', registration.password)
    });
  }

  goToLogin(): void {
    this.successfulRegistration.next();
  }
}
