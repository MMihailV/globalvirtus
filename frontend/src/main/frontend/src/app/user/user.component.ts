import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { UserService } from './user.service';
import { User } from '../modeles/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  //Component properties
  allUsers: User[];
  statusCode: number;
  requestProcessing = false;
  userIdToUpdate = null;
  processValidation = false;
  //Create form
  userForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    fkRole: new FormControl('', Validators.required)
  });
  //Create constructor to get service instance
  constructor(private userService: UserService) {
  }
  //Create ngOnInit() and and load users
  ngOnInit(): void {
    this.getAllUsers();
  }
  //Fetch all users
  getAllUsers() {
    this.userService.getAllUsers()
      .subscribe(
        data => this.allUsers = data,
        errorCode =>  this.statusCode = errorCode);
  }
  //Handle create and update user
 /* onUserFormSubmit() {
    this.processValidation = true;
    if (this.userForm.invalid) {
      return; //Validation failed, exit from method.
    }
    //Form is valid, now perform create or update
    this.preProcessConfigurations();
    let firstName = this.userForm.get('firstName').value.trim();
    let lastName = this.userForm.get('lastName').value.trim();
    let email = this.userForm.get('email').value.trim();
    let login = this.userForm.get('username').value.trim();
    let password = this.userForm.get('password').value.trim();
    let fkRole = this.userForm.get('fkRole').value.trim();
    if (this.userIdToUpdate === null) {
      //Handle create user
      let user = new User (null, username, password, email, firstName, lastName, fkRole);
      this.userService.createUser(user)
        .subscribe(successCode => {
            this.statusCode = successCode;
            this.getAllUsers();
            this.backToCreateUser();
          },
          errorCode => this.statusCode = errorCode);
    } else {
      //Handle update user
      let user = new User(this.userIdToUpdate, username, password, email, firstName, lastName, fkRole);
      this.userService.updateUser(user)
        .subscribe(successCode => {
            this.statusCode = successCode;
            this.getAllUsers();
            this.backToCreateUser();
          },
          errorCode => this.statusCode = errorCode);
    }
  }*/
  //Load user by id to edit
  /*loadUserToEdit(userId: string) {
    this.preProcessConfigurations();
    this.userService.getUserById(userId)
      .subscribe(user => {
          this.userIdToUpdate = user.userId;
          this.userForm.setValue({ username: user.username, password: user.password, email: user.email, firstName: user.firstName, lastName: user.lastName, fkRole: user.fkRole });
          this.processValidation = true;
          this.requestProcessing = false;
        },
        errorCode =>  this.statusCode = errorCode);
  }*/
  //Delete user
  deleteUser(userId: string) {
    this.preProcessConfigurations();
    this.userService.deleteUserById(userId)
      .subscribe(successCode => {
          this.statusCode = successCode;
          this.getAllUsers();
          this.backToCreateUser();
        },
        errorCode => this.statusCode = errorCode);
  }
  //Perform preliminary processing configurations
  preProcessConfigurations() {
    this.statusCode = null;
    this.requestProcessing = true;
  }
  //Go back from update to create
  backToCreateUser() {
    this.userIdToUpdate = null;
    this.userForm.reset();
    this.processValidation = false;
  }
}
