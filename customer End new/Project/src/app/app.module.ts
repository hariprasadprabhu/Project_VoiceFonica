import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CountdownModule } from 'ngx-countdown';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomePrepaidComponent } from './home-prepaid/home-prepaid.component';
import { PrepaidPlansComponent } from './prepaid-plans/prepaid-plans.component';
import { PrepaidhomeComponent } from './prepaidhome/prepaidhome.component';
import { PrepaidCurrentPlanComponent } from './prepaid-current-plan/prepaid-current-plan.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomePrepaidComponent,
    PrepaidPlansComponent,
    PrepaidhomeComponent,
    PrepaidCurrentPlanComponent,
    HeaderComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CountdownModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
