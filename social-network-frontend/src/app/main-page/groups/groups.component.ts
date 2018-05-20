import {Component, OnInit} from '@angular/core';
import {GroupsService} from './shared/groups.service';
import {Group} from './shared/group';

@Component({
  selector: 'app-groups',
  templateUrl: './groups.component.html',
  styleUrls: ['./groups.component.css']
})
export class GroupsComponent implements OnInit {
  groups: Group;

  constructor(private groupsService: GroupsService) {
  }

  ngOnInit() {
    this.getGroups();
  }

  getGroups(): void {
    this.groupsService.getGroups().subscribe(
      res => {
        if (res && res.result === 0) {
          this.groups = res.groups;
        }
      }
    );
  }

}
