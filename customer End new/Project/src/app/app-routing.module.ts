import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomePrepaidComponent } from './home-prepaid/home-prepaid.component';
import { RegistrationComponent } from './registration/registration.component';
import { PrepaidPlansComponent } from './prepaid-plans/prepaid-plans.component';
import { PrepaidCurrentPlanComponent } from './prepaid-current-plan/prepaid-current-plan.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path:'',redirectTo:'home', pathMatch:'full'},
  {path:'register',component:RegistrationComponent},
  {path:'loginsuccess',component:HomePrepaidComponent},
  {path:'login',component:LoginComponent},
  {path:'prepaidplans',component:PrepaidPlansComponent},
  {path:'prepaidcurrentplans',component:PrepaidCurrentPlanComponent},
  {path:"home",component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
