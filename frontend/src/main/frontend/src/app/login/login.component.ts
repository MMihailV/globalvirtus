import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  templateUrl: 'login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  ngOnInit() {
    let body = document.getElementsByTagName('body')[0];
    body.classList.add("login-bg");   //for white background of login and register pages
  }
}
