import {Component, OnInit} from '@angular/core';
import {MainPageService} from './shared/main-page.service';
import {ActivatedRoute} from '@angular/router';
import {Profile} from './shared/profile';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  userId: string;
  profile: Profile;

  constructor(private mainPageService: MainPageService,
              private route: ActivatedRoute) {
    this.route.queryParams.subscribe(params => {
      this.userId = params['id'];
    });
  }

  ngOnInit() {
    this.mainPageService.getProfile(this.userId).subscribe(
      res => {
        if (res && res.result === 0) {
          this.profile = res.profile;
        }
      }, err => {
        console.log(err);
      }
    );
  }

}
