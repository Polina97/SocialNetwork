import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GroupsService {
  private groupsUrl = 'groups';

  constructor(private http: HttpClient) {
  }

  getGroups(): Observable<any> {
    return this.http.post(this.groupsUrl + '/getGroups', null);
  }
}
