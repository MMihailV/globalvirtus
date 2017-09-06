import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RouterModule, PreloadAllModules } from '@angular/router';
import { ROUTES } from './app.routes';
import { HomeComponent } from './home/home.component';
import { DragulaModule } from 'ng2-dragula';
import { UserService } from './user/user.service';
import { UserComponent } from './user/user.component';
import { DashboardComponent } from './dashboard/dashboard.component';

// used to create fake backend
//import { fakeBackendProvider } from './helpers/fake-backend';
import { MockBackend, MockConnection } from '@angular/http/testing';
import { BaseRequestOptions } from '@angular/http';

import { AuthGuard } from './guards/index';
import { AuthenticationService } from './services/index';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent,
    HomeComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    DragulaModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(ROUTES, { useHash: true, preloadingStrategy: PreloadAllModules }),
    ReactiveFormsModule
  ],
  providers: [
    UserService,

    AuthGuard,
    AuthenticationService,

    // providers used to create fake backend
   // fakeBackendProvider,
    MockBackend,
    BaseRequestOptions
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
