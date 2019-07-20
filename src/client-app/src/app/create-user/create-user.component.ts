import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss']
})
export class CreateUserComponent implements OnInit {

  user: User = new User();
  submitted: boolean = false;
  @ViewChild("registerForm", { static: false }) registerForm: NgForm;

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
  }
  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }
  save() {
    this.userService.createUser(this.user)
      .subscribe(data =>
        console.log(data),
        error => console.log(error)
      );
    this.gotoList();
  }
  onSubmitData(registerForm) {
    this.submitted = true;
    this.user.id = registerForm.userName;
    this.user.email = registerForm.email;
    this.user.address = registerForm.address;
    this.user.phoneNumber = registerForm.phoneNumber;
    this.save();
  }
  gotoList(){
    this.router.navigate(['/users']);
  }
}
