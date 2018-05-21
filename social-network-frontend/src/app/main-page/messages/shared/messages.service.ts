import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessagesService {
  private messageUrl = 'message';

  constructor(private http: HttpClient) {
  }

  writeMessage(profileId: string, friendId: string, message: string): Observable<any> {
    return this.http.post(this.messageUrl + '/writeMessage', null, {
      params: new HttpParams()
        .set('ownerId', profileId)
        .set('targetId', friendId)
        .set('message', message)
    });
  }

  getDialogs(profileId: string): Observable<any> {
    return this.http.post(this.messageUrl + '/getDialogs', null, {
      params: new HttpParams()
        .set('ownerId', profileId)
    });
  }

  getAllMessages(profileId: string, targetId: string): Observable<any> {
    return this.http.post(this.messageUrl + '/getAllMessages', null, {
      params: new HttpParams()
        .set('ownerId', profileId)
        .set('targetId', targetId)
    });
  }
}
