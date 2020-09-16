import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomePrepaidComponent } from './home-prepaid/home-prepaid.component';
import { RegistrationComponent } from './registration/registration.component';
import { PrepaidPlansComponent } from './prepaid-plans/prepaid-plans.component';
import { HomeComponent } from './home/home.component';
import { PrepaidhomeComponent } from './prepaidhome/prepaidhome.component';
import { QueryComponent } from './query/query.component';
import { PrepaidHistoryComponent } from './prepaid-history/prepaid-history.component';

const routes: Routes = [
  {path:'',redirectTo:'home', pathMatch:'full'},
  {path:'register',component:RegistrationComponent},
  {path:'loginsuccess',component:HomePrepaidComponent},
  {path:'login',component:LoginComponent},
  {path:'prepaidplans',component:PrepaidPlansComponent},
  {path:"home",component:HomeComponent},
  {path:'homeprepaid',component:HomePrepaidComponent},
  {path:'query',component:QueryComponent},
  {path:'history',component:PrepaidHistoryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
