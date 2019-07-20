import { Component, OnInit } from '@angular/core';
import { Observable, from } from 'rxjs';
import { Router } from '@angular/router';
import { UserDetailComponent } from './../user-detail/user-detail.component';
import { User } from './../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-collections',
  templateUrl: './user-collections.component.html',
  styleUrls: ['./user-collections.component.scss']
})
export class UserCollectionsComponent implements OnInit {

  userList: Observable<User[]>;

  constructor(private userService: UserService, private router: Router) {

  }

  ngOnInit() {
  }

  reloadData() {
    this.userList = this.userService.getUserList();
  }
  deleteUser(id: number) {
    this.userService.deleteUser(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  userDetails(id: number) {
    this.router.navigate(['details', id]);
  }
}
