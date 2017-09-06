import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  templateUrl: 'login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  model: any = {};
  loading = false;
  error = '';

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
    let body = document.getElementsByTagName('body')[0];
    body.classList.add("login-bg");   //for white background of login and register pages

    // reset login status
    this.authenticationService.logout();
  }

  login() {
    this.loading = true;
    this.authenticationService.login(this.model.username, this.model.password)
      .subscribe(result => {
        if (result === true) {
          this.router.navigate(['/dashboard']);
        } else {
          this.error = 'Username or password is incorrect';
          this.loading = false;
        }
      });
  }
}
