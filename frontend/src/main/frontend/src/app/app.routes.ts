import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';

export const ROUTES: Routes = [
  { path: 'login',  component: LoginComponent },
  { path: '',  component: HomeComponent },
  { path: 'home',  component: HomeComponent },
  { path: 'user', component: UserComponent}
];
